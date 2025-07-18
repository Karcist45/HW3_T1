package com.barbirms.synthetichumancorestarter;

import com.barbirms.synthetichumancorestarter.commandModule.CommandRunner;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Counter;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MetricsCollector {

    private final MeterRegistry registry;

    private final CommandRunner commandRunner;


    @Autowired
    public MetricsCollector(MeterRegistry registry, CommandRunner commandRunner) {
        this.registry = registry;
        this.commandRunner = commandRunner;
    }

    @PostConstruct
    public void bindMetrics() {
        Gauge.builder("tasks.queued",
                        commandRunner,
                        cr -> cr.getExecutor().getQueue().size())
                .description("Number of tasks currently queued in executor")
                .register(registry);
        bindAll();
    }

    @Scheduled(fixedRateString = "1000", initialDelayString = "0")
    public void bindAll() {
        for (Map.Entry<String, AtomicInteger> e : commandRunner.getDictionary().entrySet()) {
            String author = e.getKey();
            AtomicInteger counter = e.getValue();

            registry.gauge(
                    "tasks_queued_by_author",
                    Tags.of("author", author),
                    counter
            );
        }
    }

}