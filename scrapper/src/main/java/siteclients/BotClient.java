package siteclients;

import org.springframework.web.service.annotation.HttpExchange;
import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

@HttpExchange(accept = APPLICATION_JSON)
public interface BotClient {

    /*@PostExchange(url = "/{id}/notification")
    void sendNotification(@PathVariable("id") Long chatId, @RequestBody List<ClassResponse> info);

    @PostExchange(url = "/{id}/mailing")
    void sendMailing(@PathVariable("id") Long chatId, @RequestBody ClassResponse info);*/
}
