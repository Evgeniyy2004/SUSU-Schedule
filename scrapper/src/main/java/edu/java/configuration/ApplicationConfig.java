package edu.java.configuration;

import edu.java.siteclients.BotClient;
import io.swagger.api.JdbcScheduleRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import javax.sql.DataSource;
import listener.ScheduleUpdaterScheduler;
import lombok.Getter;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;

@ComponentScan(basePackages = "io.swagger")
@Configuration
@EnableScheduling
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class ApplicationConfig {
    private static final String BASE = "http://localhost:8081/";

    @Value("${app.codes}")
    public ArrayList<Integer> codes;

    @Value("${app.use-queue}")
    @Getter
    private static boolean useQueue;

    @Value("${app.strategy}")
    STRATEGY strategy;

    public enum STRATEGY {
        CONSTANT,
        EXPONENTIAL
    }

    @Bean
    public ScheduleUpdaterScheduler scheduler(BotClient client, JdbcScheduleRepository repo) {
        return new ScheduleUpdaterScheduler(client, repo);
    }

    private ExchangeFilterFunction withRetryableRequests() {

        return (request, next) -> next.exchange(request)
            .flatMap(clientResponse -> Mono.just(clientResponse)
                .filter(response -> codes.contains(response.statusCode().value()))
                .flatMap(response -> clientResponse.createException())
                .flatMap(Mono::error)
                .thenReturn(clientResponse))
            .retryWhen(this.retryConst());
    }

    private RetryBackoffSpec retryConst() {
        return (Retry.fixedDelay(2 + 1, Duration.ofSeconds(2)))
            .filter(throwable -> throwable instanceof WebClientResponseException)
            .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> retrySignal.failure());
    }

    @Bean
    public BotClient beanUpdates() {
        WebClient webClient = WebClient.builder().baseUrl(BASE).filter(withRetryableRequests()).build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(BotClient.class);
    }

    @Bean
    public DSLContext dslContext() throws SQLException {
            Connection conn =
                DriverManager.getConnection("jdbc:postgresql://localhost:5433/schedule", "postgres", "postgres");
            DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);
            return context;
    }


}
