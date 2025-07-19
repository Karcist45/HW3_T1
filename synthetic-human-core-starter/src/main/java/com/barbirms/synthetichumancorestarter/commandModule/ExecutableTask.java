package com.barbirms.synthetichumancorestarter.commandModule;

public abstract class ExecutableTask implements Runnable {
    private final AndroidCommand command;

    public ExecutableTask(AndroidCommand androidCommand){
        this.command = androidCommand;
    }

    public AndroidCommand getCommand() {
        return command;
    }

    public String getCommandDescription(){
        return command.description;
    }

    public String getCommandAuthor(){
        return command.author;
    }

    public String getCommandTime(){
        return command.time;
    }

    public CommandPriority getCommandPriority(){
        return command.priority;
    }
}
