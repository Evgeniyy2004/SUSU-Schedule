package edu.java.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.java.configuration.Bot;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class NotificationServerImpl {

    private final Bot bot;

    private final ObjectMapper objectMapper;

    @Autowired
    public NotificationServerImpl(ObjectMapper objectMapper, Bot bot) {
        this.objectMapper = objectMapper;
        this.bot = bot;
    }

//    /*@PostMapping("/{id}/mailing")
//    @Valid
//    public void mailingIdPost(
//        @PathVariable("id") Long id, @RequestBody
//    LessonResponse classes
//    ) {
//        try {
//            bot.sendSchedule(id, List.of(classes), false);
//        } catch (Exception ignored) {
//
//        }
//    }*/

//    @PostMapping("/{id}/notification")
//    @Valid
//    public void notifyIdPost(
//        @PathVariable("id") Long id, @RequestBody
//    List<LessonResponse> classes
//    ) {
//        try {
//            bot.sendSchedule(id, classes, true);
//        } catch (Exception ignored) {
//
//        }
//    }

}
