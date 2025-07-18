package com.barbirms.bishopprototype;

import com.barbirms.synthetichumancorestarter.commandModule.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BishopController {

    @Autowired
    TaskService taskService;
    /**
     * sends 10 fixed tasks to executor
     * convenient to showcase monitoring
     */
    @RequestMapping("/task/batch/author1")
    public void addBatchAuthor1() {
        AndroidCommand command = new AndroidCommand("my first command",
                CommandPriority.COMMON,
                "Me",
                "12:00");
        for(int i = 0; i <= 10; i++) {
            taskService.sendCommand(command);
        }
    }

    /**
     * Same as previous, but with different author
     */
    @RequestMapping("/task/batch/author2")
    public void addBatchAuthor2() {
        AndroidCommand command = new AndroidCommand("my first command",
                CommandPriority.COMMON,
                "NotMe",
                "12:00");
        for(int i = 0; i <= 10; i++) {
            taskService.sendCommand(command);
        }
    }

    /**
     * Allows you to send your own commands
     * They are logged via custom annotation
     * Allows you to check constraints of command
     */
    @RequestMapping("/task/log/{author}/{description}/{time}/{priority}")
    public void addLoggedTask(@PathVariable String author, @PathVariable String description, @PathVariable String time, @PathVariable CommandPriority priority) {
        AndroidCommand command = new AndroidCommand(description, priority, author, time);
        taskService.sendCommandLogged(command);
    }
    /**
     * Exception handlers
     */
}
