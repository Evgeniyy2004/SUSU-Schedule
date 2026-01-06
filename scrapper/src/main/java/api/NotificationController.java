package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.JdbcNotificationService;

@RestController
public class NotificationController {

    private ObjectMapper objectMapper;

    private JdbcNotificationService notificationService;

    public NotificationController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /*@PostMapping("/{id}/mailing")
    @Operation
    public ResponseEntity mailingIdPost(
        @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable
        Integer id, @RequestParam("do") Integer mailing
    ) {
        notificationService.changeMailing(id, mailing);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/mailing")
    @Operation
    public ResponseEntity<Boolean> mailingIdGet(
        @PathVariable("id")
        Integer id
    ) {
        return ResponseEntity.ok(notificationService.getMailing(id));
    }

    @PostMapping("/{id}/group")
    @Operation
    public ResponseEntity groupIdPost(
        @PathVariable("id")
        Integer id, @RequestParam("new") String group
    ) {
        notificationService.add(id, group);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/group")
    @Operation
    public ResponseEntity<Boolean> groupIdCheck(
        @PathVariable("id")
        Integer id
    ) {

        return ResponseEntity.ok(notificationService.check(id));
    }

    @PostMapping("/{id}/notify")
    @Operation
    public ResponseEntity notifyIdPost(
        @PathVariable("id")
        Integer id, @RequestParam("new") boolean notify
    ) {
        notificationService.changeNotificationStatus(id, notify);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/notify")
    @Operation
    public ResponseEntity<Boolean> notifyIdGet(
        @PathVariable("id")
        Integer id
    ) {
        return ResponseEntity.ok(notificationService.getNotification(id));
    }*/

}
