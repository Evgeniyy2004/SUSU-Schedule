package edu.java.services;

import edu.java.model.ClassResponse;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.java.repos.ScheduleRepository;

@Service
public class ScheduleService {

    private final ScheduleRepository repo;


    public ScheduleService(ScheduleRepository repo) {
        this.repo = repo;
    }

    public List<ClassResponse> getSchedule(long tgChatId, String timediff) {
        return repo.findAll(tgChatId, timediff);
    }

}
