package services;

import java.util.List;
import org.springframework.stereotype.Service;
import repos.JdbcScheduleRepository;

@Service
public class JdbcScheduleService {

    private final JdbcScheduleRepository repo;


    public JdbcScheduleService(JdbcScheduleRepository repo) {
        this.repo = repo;
    }

    /*public List<LessonResponse> getSchedule(long tgChatId, String timediff) {
        return repo.findAll(tgChatId, timediff);
    }
*/
}
