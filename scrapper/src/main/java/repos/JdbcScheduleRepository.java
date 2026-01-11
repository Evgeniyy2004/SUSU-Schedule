package repos;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.jooq.Result;
import org.jooq.TableField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import jooq.tables.records.LessonsRecord;
import static jooq.tables.Lessons.LESSONS;
import static jooq.tables.Student.STUDENT;
import static jooq.tables.Groups.GROUPS;
import LessonResponse;

@Repository
@SuppressWarnings("all")
public class JdbcScheduleRepository {

    private final DSLContext context;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final List<TableField> classFields = Arrays.asList(
        LESSONS.CLASSDATE, LESSONS.DISCIPLINE,
        LESSONS.CLASSTIME, LESSONS.CLASSROOM
    );

    public JdbcScheduleRepository(DSLContext context) {
        this.context = context;
    }

    public void removeOld() {
        context.deleteFrom(LESSONS)
            .where(LESSONS.CLASSDATE.lessThan(LocalDate.now())).execute();
    }

    public List<LessonResponse> findAll(Long id, String timediff) {
        Result<LessonsRecord> res;
        LocalDate date = LocalDate.now();
        date.plusDays(Integer.valueOf(timediff));
        res = (Result<LessonsRecord>) context.select(classFields)
            .from(LESSONS).join(STUDENT).
            on(STUDENT.GROUPID.eq(LESSONS.GROUPID))
            .where(LESSONS.CLASSDATE.eq(date)).fetchInto(LESSONS);

        Map<String, LessonResponse> map2 = new HashMap<String, LessonResponse>();
        for (LessonsRecord row : res) {
            String currDateStr = row.getClassdate().format(formatter);
            if (!map2.containsKey(currDateStr)) {
                map2.put(currDateStr, new LessonResponse());
                map2.get(currDateStr).setDay(currDateStr);
            }
            map2.get(currDateStr).addLesson(row.getClasstime(), row.getClassroom(), row.getDiscipline());
        }

        LessonResponse valueforEmpty = new LessonResponse();

        return map2.values().stream().toList();
    }

    public Pair<Map<Pair<String, String>, LessonResponse>,
        Map<Pair<String, String>, LessonResponse>> update() {
        removeOld();
        Map<String, List<LessonResponse>> result = new HashMap<>();
        Map<Pair<String, String>, LessonResponse> map = new HashMap<>();

        var data = context.selectFrom(LESSONS.join(GROUPS).
            on(LESSONS.GROUPID.eq(GROUPS.ID))).orderBy(LESSONS.CLASSTIME).fetch();

        var res = data.stream().map(c -> {
            List<String> row = new ArrayList<>();
            try {
                ResultSet set = c.intoResultSet();
                row.add(set.getString("GroupName"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                var date = sdf.format(set.getDate("ClassDate"));
                row.add(date);
                row.add(set.getString("Discipline"));
                row.add(set.getString("ClassTime"));
                row.add(set.getString("Classroom"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return row;
        }).toList();

        Map<Pair<String, String>, LessonResponse> updated = new HashMap<>();
        Map<Pair<String, String>, LessonResponse> added = new HashMap<>();
        for (List<String> row : res) {
            if (!map.containsKey(Pair.of(row.get(0), row.get(1)))) {
                var currResponse = new LessonResponse();
                currResponse.setDay(row.get(1));
                map.put(Pair.of(row.get(0), row.get(1)), currResponse);
            }
            map.get(Pair.of(row.get(0), row.get(1))).addLesson(row.get(3), row.get(4), row.get(2));
        }

        for (String s : context.select(GROUPS.GROUPNAME).from(GROUPS).fetchInto(String.class)) {
            try {
                var neww = getFromSite(s);
                for (Map.Entry<Pair<String, String>, LessonResponse> entry : neww.entrySet()) {
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

    public Map<Long, List<LessonResponse>> getForNotifications(Map<Pair<String, String>, LessonResponse> data) {
        Map<Long, List<LessonResponse>> result = new HashMap<>();
        Set<String> changedGroups = new HashSet<>();
        for (Map.Entry<Pair<String, String>, LessonResponse> entry : data.entrySet()) {
            changedGroups.add("\'" + entry.getKey().getLeft() + "\'");
        }

        if (changedGroups.size() == 0) {
            return result;
        }

        var pairs = context.select(
                STUDENT.ID.as("student_id"),
                GROUPS.GROUPNAME.as("group_name")
            )
            .from(STUDENT)
            .join(GROUPS)
            .on(GROUPS.ID.eq(STUDENT.GROUPID)).where(STUDENT.ISNOTIFIED)
            .and(GROUPS.GROUPNAME.in(changedGroups)).fetch()
            .stream().map(s -> Pair.of(s.component1(), s.component2())).toList();

        for (Pair<Long, String> pair : pairs) {
            var filtered = data.entrySet().stream()
                .filter(r -> r.getKey().getLeft() == pair.getRight()).collect(Collectors.toSet());
            if (filtered.size() > 0) {
                result.put(pair.getLeft(), new ArrayList<>());
                for (Map.Entry<Pair<String, String>, LessonResponse> f : filtered) {
                    var currresponse = f.getValue();
                    result.get(pair.getLeft()).add(currresponse);
                }
            }
        }
        return result;
    }

    public Map<Pair<String, String>, LessonResponse> getFromSite(String groupName) throws IOException {
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

        Map<Pair<String, String>, LessonResponse> result = new HashMap<>();

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
                result.put(currkey, new LessonResponse());
                result.get(currkey).setDay(dateOfClass);
            } else {
                result.get(currkey).addLesson(row.get("Время"), row.get("Место"), row.get("Дисциплина"));
            }
        }
        return result;
    }

    public boolean isNotified(Integer chatId) {
        return !context.selectFrom(STUDENT)
            .where(STUDENT.ID.eq(Long.valueOf(chatId))).and(STUDENT.ISNOTIFIED.eq(true)).fetch().isEmpty();
    }

    public List<Pair<Long, Integer>> mailingTimes() {
        var res = context.select(STUDENT.ID, STUDENT.MAILINGTIME)
            .from(STUDENT)
            .fetch().stream().map(c -> Pair.of(c.component1(), c.component2()))
            .collect(Collectors.toList());
        return res;
    }

    public void updateAllClasses(
        Map<Pair<String, String>, LessonResponse> updated,
        Map<Pair<String, String>, LessonResponse> added
    ) {

        var res = context.selectFrom(GROUPS).stream()
            .map(group -> Pair.of(group.component2(), group.component1()))
            .collect(Collectors.toMap(p -> p.getLeft(), p -> p.getRight()));

        for (Map.Entry<Pair<String, String>, LessonResponse> entry : updated.entrySet()) {
            var groupname = entry.getKey().getLeft();
            var groupId = res.get(groupname);
            context.deleteFrom(CLASSES).where(CLASSES.GROUPID.eq(groupId))
                .and(CLASSES.CLASSDATE.eq
                    (LocalDate.parse(
                        entry.getKey().getRight(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")
                    )));
        }

        saveToClasses(updated, res);
        saveToClasses(added, res);
    }

    public void saveToClasses(
        Map<Pair<String, String>, LessonResponse> toWrite,
        Map<String, Integer> groupnameToId
    ) {
        List<LessonsRecord> list = new ArrayList<>();
        for (Map.Entry<Pair<String, String>, LessonResponse> entry : toWrite.entrySet()) {
            LessonResponse classResponse = entry.getValue();
            var groupname = entry.getKey().getLeft();
            var groupId = groupnameToId.get(groupname);
            for (int g = 0; g < classResponse.getClassrooms().size(); g++) {
                var subject = classResponse.getSubjects().get(g);
                var date = LocalDate.parse(
                    classResponse.getDay(),
                    DateTimeFormatter.ofPattern("dd.MM.yyyy")
                );
                var time = classResponse.getTimeList().get(g);
                var classroom = classResponse.getClassrooms().get(g);
                LessonsRecord lessons = new LessonsRecord();
                lessons.set(LESSONS.GROUPID, groupId);
                lessons.set(LESSONS.DISCIPLINE, subject);
                lessons.set(LESSONS.CLASSDATE, date);
                lessons.set(LESSONS.CLASSTIME, time);
                lessons.set(LESSONS.CLASSROOM, classroom);
                list.add(lessons);
            }
        }
        context.insertInto(LESSONS).values(list);
    }

}
