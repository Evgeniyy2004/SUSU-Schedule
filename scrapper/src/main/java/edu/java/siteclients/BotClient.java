package edu.java.siteclients;

import edu.java.model.ClassResponse;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

@HttpExchange(accept = APPLICATION_JSON)
public interface BotClient {

    @PostExchange(url = "/{id}/notification")
    void sendNotification(@PathVariable("id") Long chatId, @RequestBody List<ClassResponse> info);

    @PostExchange(url = "/{id}/mailing")
    void sendMailing(@PathVariable("id") Long chatId, @RequestBody ClassResponse info);
}
