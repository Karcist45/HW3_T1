package com.barbirms.synthetichumancorestarter;

public class AndroidCommand {
    String description;
    CommandPriority priority;
    String author;
    String time;

    public AndroidCommand(String description, CommandPriority priority, String author, String time) {
        // todo: validation and errors
        this.description = description;
        this.priority = priority;
        this.author = author;
        this.time = time;
    }
}
