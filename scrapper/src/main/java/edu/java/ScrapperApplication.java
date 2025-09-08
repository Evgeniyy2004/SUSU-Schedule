package edu.java;

import edu.java.configuration.ApplicationConfig;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class ScrapperApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Yekaterinburg"));
        SpringApplication.run(ScrapperApplication.class, args);
    }

    @Bean // Declares this method as a Spring Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(new Info().title("Schedule Scrapper API") // Schedule Scrapper API
                .description("This document provides API details for a sample product Spring Boot Project")); // Sets the API description
    }
}
