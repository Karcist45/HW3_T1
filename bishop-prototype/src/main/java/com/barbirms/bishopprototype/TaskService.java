package com.barbirms.bishopprototype;

import com.barbirms.synthetichumancorestarter.audit.WeylandWatchingYou;
import com.barbirms.synthetichumancorestarter.commandModule.AndroidCommand;
import com.barbirms.synthetichumancorestarter.commandModule.CommandRunner;
import com.barbirms.synthetichumancorestarter.commandModule.ConsoleExecutableTask;
import com.barbirms.synthetichumancorestarter.commandModule.ExecutableTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {
    @Autowired
    CommandRunner runner;

    public String sendCommand(AndroidCommand command) {
        ExecutableTask task = new ConsoleExecutableTask(command);
        runner.AddTask(task);
        return "Success";
    }

    @WeylandWatchingYou
    public String sendCommandLogged(AndroidCommand command) {
        ExecutableTask task = new ConsoleExecutableTask(command);
        runner.AddTask(task);
        return "Success";
    }
}
