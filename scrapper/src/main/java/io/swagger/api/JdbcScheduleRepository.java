package io.swagger.api;

import edu.java.jooq.tables.Groups;
import edu.java.model.ClassResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.TableField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import static edu.java.jooq.Tables.CLASSES;
import static edu.java.jooq.Tables.GROUPS;
import static edu.java.jooq.tables.Student.STUDENT;
import static org.jooq.impl.DSL.currentDate;

@Repository
@SuppressWarnings("all")
public class JdbcScheduleRepository {

    private final DSLContext context;

    @Autowired
    public JdbcScheduleRepository(DSLContext context) {
        this.context = context;
    }

    public void removeOld() {
        context.deleteFrom(CLASSES)
            .where(CLASSES.CLASSDATE.lessThan(LocalDate.now())).execute();
    }

    public List<ClassResponse> findAll(Long id, String timediff) {
        String res;
        List<TableField> fields = Arrays.asList(CLASSES.CLASSDATE,CLASSES.DISCIPLINE,
            CLASSES.CLASSTIME,CLASSES.CLASSROOM);
        if (timediff.equals("0")) {
            context.select(fields)
                .from(CLASSES).join(STUDENT).
                on(STUDENT.GROUPID.eq(CLASSES.GROUPID))

                .where(GROUPS.GROUPNAME.eq(group)).fetchOne();
            sql = "SELECT ClassDate,Discipline,ClassTime,Classroom\n" +
                "FROM classes \n JOIN Student on Student.GroupId=classes.GroupId Where Student.Id=" + id +
                " AND ClassDate = CURRENT_DATE;";
        } else if (timediff.equals("1")) {
            sql = "SELECT ClassDate,Discipline,ClassTime,Classroom\n" +
                "FROM classes \n JOIN Student on Student.GroupId=classes.GroupId Where Student.Id=" + id +
                " AND ClassDate = CURRENT_DATE + INTERVAL '1 day';";
        } else {
            sql = "SELECT ClassDate,Discipline,ClassTime,Classroom\n" +
                "FROM classes \n JOIN Student on Student.GroupId=classes.GroupId Where Student.Id=" + id +
                " AND ClassDate <= DATE_TRUNC('week', CURRENT_DATE) + INTERVAL '6 days';";
        }


        Map<String, ClassResponse> map2 = new HashMap<String, ClassResponse>();
        for (List<String> row : res) {
            if (!map2.containsKey(row.get(0))) {
                map2.put(row.get(0), new ClassResponse());
                map2.get(row.get(0)).setDay(row.get(0));
            }
            map2.get(row.get(0)).addClass(row.get(2), row.get(3), row.get(1));
        }

        ClassResponse valueforEmpty = new ClassResponse();

        return map2.values().stream().toList();
    }

    public Pair<Map<Pair<String, String>, ClassResponse>,
        Map<Pair<String, String>, ClassResponse>> update() {
        removeOld();
        String sql = "SELECT GroupName FROM Groups";
        var allGroups = jdbcTemplate.queryForList(sql, String.class);
        Map<String, List<ClassResponse>> result = new HashMap<>();
        Map<Pair<String, String>, ClassResponse> map = new HashMap<>();

        var res = jdbcTemplate.query(
            "select * from Classes " +
                "join Groups on Classes.GroupId=Groups.Id order by ClassTime",
            new ResultSetExtractor<List<List<String>>>() {
                @Override
                public List<List<String>> extractData(ResultSet rs) throws SQLException {
                    List<List<String>> result = new ArrayList<>();
                    while (rs.next()) {
                        List<String> row = new ArrayList<>();
                        row.add(rs.getString("GroupName"));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        var date = sdf.format(rs.getDate("ClassDate"));
                        row.add(date);
                        row.add(rs.getString("Discipline"));
                        row.add(rs.getString("ClassTime"));
                        row.add(rs.getString("Classroom"));
                        result.add(row);
                    }

                    return result;
                }
            }
        );

        Map<Pair<String, String>, ClassResponse> updated = new HashMap<>();
        Map<Pair<String, String>, ClassResponse> added = new HashMap<>();
        for (List<String> row : res) {
            if (!map.containsKey(Pair.of(row.get(0), row.get(1)))) {
                var currResponse = new ClassResponse();
                currResponse.setDay(row.get(1));
                map.put(Pair.of(row.get(0), row.get(1)), currResponse);
            }
            map.get(Pair.of(row.get(0), row.get(1))).addClass(row.get(3), row.get(4), row.get(2));
        }

        for (String s : jdbcTemplate.queryForList("select GroupName from Groups", String.class)) {
            try {
                var neww = getFromSite(s);
                for (Map.Entry<Pair<String, String>, ClassResponse> entry : neww.entrySet()) {
                    var key = entry.getKey();
                    var value = entry.getValue();
                    if (!new SimpleDateFormat("dd.MM.yyyy").parse(key.getValue()).before(new Date())) {
                        if (map.containsKey(key) && !map.get(key).equals(value)) {
                            updated.put(key, value);
                        } else if (!map.containsKey(key)) {
                            added.put(key, value);
                        }
                    }
                }
            } catch (Exception ignored) {

            }
        }

        return Pair.of(updated, added);
    }

    public Map<Long, List<ClassResponse>> getForNotifications(Map<Pair<String, String>, ClassResponse> data) {
        Map<Long, List<ClassResponse>> result = new HashMap<>();
        Set<String> changedGroups = new HashSet<>();
        for (Map.Entry<Pair<String, String>, ClassResponse> entry : data.entrySet()) {
            changedGroups.add("\'" + entry.getKey().getLeft() + "\'");
        }

        if (changedGroups.size() == 0) {
            return result;
        }
        String groupsStr = String.join(",", changedGroups);

        var sql =
            "select  Student.Id AS student_id, Groups.groupname as group_name  FROM Student join Groups on Student.GroupId=Groups.Id" +
                " where Groups.groupname in (" + groupsStr + ") and IsNotified=TRUE";

        var pairs = jdbcTemplate.query(sql
            , new ResultSetExtractor<List<Pair<Long, String>>>() {
                @Override
                public List<Pair<Long, String>> extractData(ResultSet rs) throws SQLException {
                    List<Pair<Long, String>> result = new ArrayList<>();
                    while (rs.next()) {
                        List<String> row = new ArrayList<>();
                        row.add(String.valueOf(rs.getLong("student_id")));
                        row.add(rs.getString("group_name"));
                    }

                    return result;
                }
            });

        for (Pair<Long, String> pair : pairs) {
            var filtered = data.entrySet().stream()
                .filter(r -> r.getKey().getLeft() == pair.getRight()).collect(Collectors.toSet());
            if (filtered.size() > 0) {
                result.put(pair.getLeft(), new ArrayList<>());
                for (Map.Entry<Pair<String, String>, ClassResponse> f : filtered) {
                    var currresponse = f.getValue();
                    result.get(pair.getLeft()).add(currresponse);
                }
            }
        }
        return result;
    }

    public Map<Pair<String, String>, ClassResponse> getFromSite(String groupName) throws IOException {
        Document doc = Jsoup.connect("https://www.susu.ru/ru/lessons/" + groupName).get();
        var table = doc.select("table");
        var tbody = table.select("tbody").getFirst();
        Elements dataRows = tbody.select("tr");
        Elements headerRow = table.select("tr")
            .get(0)
            .select("th,td");

        List<String> headers = new ArrayList();
        for (Element header : headerRow) {
            headers.add(header.text());
        }

        Map<Pair<String, String>, ClassResponse> result = new HashMap<>();

        List<Map<String, String>> parsedDataRows = new ArrayList();
        for (int row = 0; row < dataRows.size(); row++) {
            Elements colVals = dataRows.get(row).select("th,td");

            int colCount = 0;
            Map<String, String> dataRow = new HashMap();
            for (Element colVal : colVals) {
                dataRow.put(headers.get(colCount++), colVal.text());
            }
            parsedDataRows.add(dataRow);
        }

        Pair<String, String> currkey = Pair.of(groupName, groupName);
        for (Map<String, String> row : parsedDataRows) {
            if (row.size() == 1) {
                var dateOfClass = row.get("Время").strip().split(" ")[1];
                currkey = new ImmutablePair<>(groupName, dateOfClass);
                result.put(currkey, new ClassResponse());
                result.get(currkey).setDay(dateOfClass);
            } else {
                result.get(currkey).addClass(row.get("Время"), row.get("Место"), row.get("Дисциплина"));
            }
        }
        return result;
    }

    public boolean isNotified(Integer chatId) {
        var maybe = jdbcTemplate.queryForList("select * from Student where ChatId=? AND IsNotified=TRUE", chatId);
        return maybe.size() > 0;
    }

    public List<Pair<Long, Integer>> mailingTimes() {
        var res = jdbcTemplate.query(
            "select Id,MailingTime from Student",
            new ResultSetExtractor<List<Pair<Long, Integer>>>() {
                @Override
                public List<Pair<Long, Integer>> extractData(ResultSet rs) throws SQLException {
                    List<Pair<Long, Integer>> result = new ArrayList<>();
                    while (rs.next()) {

                        result.add(Pair.of(rs.getLong("Id"), rs.getInt("MailingTime")));
                    }

                    return result;
                }
            }
        );
        return res;
    }

    public void updateAllClasses(
        Map<Pair<String, String>, ClassResponse> updated,
        Map<Pair<String, String>, ClassResponse> added
    ) {

        var res = jdbcTemplate.query("select * from Groups", new ResultSetExtractor<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> extractData(ResultSet rs) throws SQLException {
                Map<String, Integer> result = new HashMap<>();
                while (rs.next()) {

                    result.put(rs.getString("GroupName"), rs.getInt("Id"));
                }

                return result;
            }
        });

        for (Map.Entry<Pair<String, String>, ClassResponse> entry : updated.entrySet()) {
            var groupname = entry.getKey().getLeft();
            var groupId = res.get(groupname);
            jdbcTemplate.update("DELETE FROM classes WHERE GroupId=?" +
                " AND ClassDate=TO_DATE(?,'dd.mm.yyyy')", groupId, entry.getKey().getRight());
        }

        for (Map.Entry<Pair<String, String>, ClassResponse> entry : updated.entrySet()) {
            var groupname = entry.getKey().getLeft();
            var groupId = res.get(groupname);
            for (int g = 0; g < entry.getValue().getClassrooms().size(); g++) {
                var subject = entry.getValue().getSubjects().get(g);
                var date = entry.getValue().getDay();
                var time = entry.getValue().getTime().get(g);
                var classroom = entry.getValue().getClassrooms().get(g);
                jdbcTemplate.update("INSERT INTO classes (GroupId,Discipline,classdate,classtime,ClassRoom) " +
                    "VALUES (?,?,TO_DATE(?,'dd.mm.yyyy'),?,?)", groupId, subject, date, time, classroom);
            }
        }

        for (Map.Entry<Pair<String, String>, ClassResponse> entry : added.entrySet()) {
            var groupname = entry.getKey().getLeft();
            var groupId = res.get(groupname);
            for (int g = 0; g < entry.getValue().getClassrooms().size(); g++) {
                var subject = entry.getValue().getSubjects().get(g);
                var date = entry.getValue().getDay();
                var time = entry.getValue().getTime().get(g);
                var classroom = entry.getValue().getClassrooms().get(g);
                jdbcTemplate.update("INSERT INTO classes (GroupId,Discipline,classdate,classtime,ClassRoom) " +
                    "VALUES (?,?,TO_DATE(?,'dd.mm.yyyy'),?,?)", groupId, subject, date, time, classroom);
            }
        }
    }

}
