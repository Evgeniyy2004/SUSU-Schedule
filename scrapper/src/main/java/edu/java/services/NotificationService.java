package edu.java.services;

import org.springframework.stereotype.Service;
import edu.java.repos.NotificationRepository;

@Service
public class NotificationService {
    private final NotificationRepository repo;


    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public void add(long tgChatId, String group) {
        repo.save(tgChatId, group);
    }

    public void changeNotificationStatus(long tgChatId, boolean notify) {
        repo.updateNotifications(tgChatId, notify);
    }

    public boolean getNotification(long tgChatId) {
        return repo.getNotification(tgChatId);
    }

    public void changeMailing(long tgChatId, Integer newhour) {
        repo.updateMailing(tgChatId, newhour);
    }

    public boolean getMailing(long tgChatId) {
        return repo.getMailing(tgChatId);
    }

    public boolean check(long tgChatId) {
        return repo.check(tgChatId);
    }

}
