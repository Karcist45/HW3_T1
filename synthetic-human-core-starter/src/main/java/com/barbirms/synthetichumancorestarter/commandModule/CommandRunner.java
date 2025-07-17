package com.barbirms.synthetichumancorestarter.commandModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class CommandRunner {
    @Autowired
    private ThreadPoolExecutor executor;

    public void AddTask(ExecutableTask task) throws RejectedExecutionException{
        if (task.getCommandPriority() == CommandPriority.CRITICAL){
            task.run();
        } else if (task.getCommandPriority() == CommandPriority.COMMON){
            executor.submit(task); // todo: catch RejectedExecutionException(should prolly catch 'em in controllers
        }
    }
}
