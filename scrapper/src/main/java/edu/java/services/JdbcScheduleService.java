package edu.java.services;

import edu.java.model.ClassResponse;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.java.repos.JdbcScheduleRepository;

@Service
public class JdbcScheduleService {

    private final JdbcScheduleRepository repo;


    public JdbcScheduleService(JdbcScheduleRepository repo) {
        this.repo = repo;
    }

    public List<ClassResponse> getSchedule(long tgChatId, String timediff) {
        return repo.findAll(tgChatId, timediff);
    }

}
