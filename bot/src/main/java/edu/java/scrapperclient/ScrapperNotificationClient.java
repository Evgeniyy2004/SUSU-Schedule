package edu.java.scrapperclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/{id}")
public interface ScrapperNotificationClient {

    @PostExchange("/mailing")
    void postMailing(@PathVariable("id") long id, @RequestParam("do")  Integer time);

    @GetExchange("/mailing")
    ResponseEntity<Boolean> getMailing(@PathVariable("id") long id);

    @PostExchange("/group")
    void groupPost(@PathVariable("id") long id, @RequestParam("new_group") String group);

    @GetExchange("/group")
    ResponseEntity<Boolean> groupGet(@PathVariable("id") long id);

    @PostExchange("/notify")
    void notifyPost(@PathVariable("id") long id, @RequestParam("new") boolean value);

    @GetExchange("/notify")
    ResponseEntity<Boolean> notifyGet(@PathVariable("id") long id);
}
