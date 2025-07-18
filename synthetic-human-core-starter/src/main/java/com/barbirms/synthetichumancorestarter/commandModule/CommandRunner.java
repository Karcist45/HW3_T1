package com.barbirms.synthetichumancorestarter.commandModule;

import com.barbirms.synthetichumancorestarter.MetricsCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CommandRunner {
    @Autowired
    private ThreadPoolExecutor executor;

    private ConcurrentHashMap<String, AtomicInteger> dictionary = new ConcurrentHashMap<>();

    public void AddTask(ExecutableTask task) throws RejectedExecutionException{
        if (dictionary.containsKey(task.getCommandAuthor())){
            dictionary.get(task.getCommandAuthor()).incrementAndGet();
        } else {
            AtomicInteger initial = new AtomicInteger(1);
            dictionary.put(task.getCommandAuthor(), initial);
        }

        if (task.getCommandPriority() == CommandPriority.CRITICAL){
            task.run();
        } else if (task.getCommandPriority() == CommandPriority.COMMON){
            executor.submit(task); // todo: catch RejectedExecutionException(should prolly catch 'em in controllers
        }
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public ConcurrentHashMap<String, AtomicInteger> getDictionary() {
        return dictionary;
    }
}
