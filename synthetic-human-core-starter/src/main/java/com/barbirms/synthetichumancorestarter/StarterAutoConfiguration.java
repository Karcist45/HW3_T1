package com.barbirms.synthetichumancorestarter;

import com.barbirms.synthetichumancorestarter.audit.AuditWriter;
import com.barbirms.synthetichumancorestarter.audit.ConsoleAuditWriter;
import com.barbirms.synthetichumancorestarter.audit.KafkaAuditWriter;
import com.barbirms.synthetichumancorestarter.audit.WeylandWatchingYouAspect;
import com.barbirms.synthetichumancorestarter.commandModule.CommandRunner;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.*;

@AutoConfiguration
@EnableConfigurationProperties(StarterProperties.class)
public class StarterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ThreadPoolExecutor executor() {
        return new ThreadPoolExecutor(2, 2, 60L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());
    }

    @Bean
    @ConditionalOnMissingBean
    public CommandRunner commandRunner() {
        return new CommandRunner();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuditWriter myService(StarterProperties properties, KafkaTemplate<String, String> kafkaTemplate) {
        switch (properties.getAuditWriterType().toUpperCase()) {
            case "CONSOLE":
                return new ConsoleAuditWriter();
            case "KAFKA":
                return new KafkaAuditWriter(kafkaTemplate);
            default:
                throw new IllegalArgumentException("Unsupported service type: " + properties.getAuditWriterType());
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public MetricsCollector metricsCollector(MeterRegistry registry, CommandRunner commandRunner) {
        return new MetricsCollector(registry, commandRunner);
    }

    @Bean
    @ConditionalOnMissingBean
    public WeylandWatchingYouAspect weylandWatchingYouAspect() {
        return new WeylandWatchingYouAspect();
    }
}
