package edu.java.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import edu.java.services.ScheduleService;

@RestController
public class ScheduleApiController {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduleApiController.class);
    private final ScheduleService scheduleService;
    private final ObjectMapper objectMapper;

    public ScheduleApiController(ObjectMapper objectMapper, ScheduleService service) {
        this.scheduleService = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/schedule/{id}/{time}")
    @Operation
    public ResponseEntity<?> schedulesGet(
        @PathVariable("id") Integer tgChatId, @PathVariable("time") String time
    ) {
        var res = scheduleService.getSchedule(tgChatId, time);
        return ResponseEntity.ok(res);
    }

}
