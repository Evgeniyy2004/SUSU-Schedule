package edu.java.configuration;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import notification.NotificationServiceGrpc;
import schedule.ScheduleServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("RegexpSinglelineJava")
public class ClientConfiguration {
    String base = "http://localhost:8080/";

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
    }

    @Bean
    public NotificationServiceGrpc.NotificationServiceBlockingStub notificationBlockingStub(ManagedChannel channel) {
        return NotificationServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public ScheduleServiceGrpc.ScheduleServiceBlockingStub scheduleBlockingStub(ManagedChannel channel) {
        return ScheduleServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public Bot bot() {
        return new Bot();
    }

}
