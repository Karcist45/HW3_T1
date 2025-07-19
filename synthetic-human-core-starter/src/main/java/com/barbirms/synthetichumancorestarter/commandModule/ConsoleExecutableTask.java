package com.barbirms.synthetichumancorestarter.commandModule;

public class ConsoleExecutableTask extends ExecutableTask {
    public ConsoleExecutableTask(AndroidCommand androidCommand) {
        super(androidCommand);
    }

    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------COMMAND--------------");
        System.out.println("AUTHOR: " + super.getCommandAuthor());
        System.out.println("DESCRIPTION: " + super.getCommandDescription());
        System.out.println("PRIORITY: " + super.getCommandPriority());
        System.out.println("TIME: " + super.getCommandTime());
        System.out.println("----------------------------------");
    }
}
