package com.barbirms.bishopprototype;

import com.barbirms.synthetichumancorestarter.audit.WeylandWatchingYou;
import com.barbirms.synthetichumancorestarter.commandModule.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BishopController {
    @Autowired
    CommandRunner runner;

    @RequestMapping("/task")
    public void addTask() {
        AndroidCommand command = new AndroidCommand("my first command",
                CommandPriority.COMMON,
                "Me",
                "12:00");
        ExecutableTask task = new ConsoleExecutableTask(command);
        for(int i = 0; i <= 10; i++) {
            runner.AddTask(task);
        }
    }

    @RequestMapping("/task/notme")
    public void addNotMineTask() {
        AndroidCommand command = new AndroidCommand("my first command",
                CommandPriority.COMMON,
                "NotMe",
                "12:00");
        ExecutableTask task = new ConsoleExecutableTask(command);
        for(int i = 0; i <= 10; i++) {
            runner.AddTask(task);
        }
    }

    @RequestMapping("/task/log/{author}")
    public String addLoggedTask(@PathVariable String author){
        return idk(author);
    }

    @WeylandWatchingYou
    public String idk(String id){
        return id;
    }
}
