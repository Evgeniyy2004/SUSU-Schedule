package edu.java.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.java.configuration.Bot;
import javax.validation.Valid;
import edu.java.model.ClassResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
@Validated
public class NotificationController {

    @Autowired
    private Bot bot;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public NotificationController(ObjectMapper objectMapper, Bot bot) {
        this.objectMapper = objectMapper;
        this.bot = bot;
    }

    @PostMapping("/{id}/mailing")
    @Valid
    public void mailingIdPost(
        @PathVariable("id") Long id,  @RequestBody
    ClassResponse classes
        ) {
        try {
            bot.sendSchedule(id, List.of(classes), false);
        } catch (Exception ignored) {

        }
    }

    @PostMapping("/{id}/notification")
    @Valid
    public void notifyIdPost(
        @PathVariable("id") Long id,  @RequestBody
    List<ClassResponse> classes
    ) {
        try {
            bot.sendSchedule(id, classes, true);
        } catch (Exception ignored) {

        }
    }

}
