package com.barbirms.synthetichumancorestarter;

import com.barbirms.synthetichumancorestarter.audit.AuditWriter;
import com.barbirms.synthetichumancorestarter.audit.ConsoleAuditWriter;
import com.barbirms.synthetichumancorestarter.commandModule.CommandRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.*;

@AutoConfiguration
public class StarterAutoConfiguration {
    @Bean
    public ThreadPoolExecutor executor() {
        return new ThreadPoolExecutor(2, 2, 60L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                new ThreadPoolExecutor.AbortPolicy());
    }

    @Bean
    public CommandRunner commandRunner() {
        return new CommandRunner();
    }

    @Bean
    public AuditWriter auditWriter() {
        return new ConsoleAuditWriter();
    }
}
