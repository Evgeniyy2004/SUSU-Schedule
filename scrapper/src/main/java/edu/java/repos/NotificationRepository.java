package edu.java.repos;

import edu.java.jooq.tables.Groups;
import edu.java.jooq.tables.records.GroupsRecord;
import java.util.HashMap;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import static edu.java.jooq.Tables.GROUPS;
import static edu.java.jooq.Tables.STUDENT;

@Repository
public class NotificationRepository {
    private final DSLContext context;
    private final ScheduleRepository scheduleRepository;

    public NotificationRepository(DSLContext context, ScheduleRepository scheduleRepository) {
        this.context = context;
        this.scheduleRepository = scheduleRepository;
    }

    public void save(Long id, String group) {
        var res = context.select()
            .from(GROUPS).where(GROUPS.ID.eq(Integer.valueOf(group))).fetchOptional();
        var isAbsent = check(id);
        if (res.isEmpty()) {
            context.insertInto(GROUPS).set(new GroupsRecord()
                .with(Groups.GROUPS.GROUPNAME, group)).execute();
            var addedClasses = scheduleRepository.update();
            scheduleRepository.updateAllClasses(new HashMap<>(), addedClasses.getRight());
        }
        var groupid = context.select(Groups.GROUPS.ID)
            .from(GROUPS).where(GROUPS.GROUPNAME.eq(group)).fetchOne();

        if (isAbsent) {
            context.insertInto(STUDENT).set(STUDENT.ID, id)
                .set(STUDENT.GROUPID, groupid.value1()).execute();
        } else {
            context.update(STUDENT).set(STUDENT.GROUPID, groupid.value1())
                .where(STUDENT.ID.eq(id)).execute();
        }
    }

    public void updateNotifications(Long id, boolean notification) {
        context.update(STUDENT).set(STUDENT.ISNOTIFIED, notification)
            .where(STUDENT.ID.eq(id)).execute();
    }

    public Boolean getNotification(Long id) {
        return context.select(STUDENT.ISNOTIFIED)
            .from(STUDENT).where(STUDENT.ID.eq(id)).fetchOne().value1();
    }

    public void updateMailing(Long id, Integer mailing) {
        context.update(STUDENT).set(STUDENT.MAILINGTIME, mailing)
            .where(STUDENT.ID.eq(id)).execute();
    }

    public Boolean getMailing(Long id) {
        return context.select(STUDENT.MAILINGTIME)
            .from(STUDENT).where(STUDENT.ID.eq(id)).fetchOne().value1() != null;
    }

    public boolean check(Long id) {
        return context.select()
            .from(STUDENT).where(STUDENT.ID.eq(id)).fetchOptional().isEmpty();
    }
}
