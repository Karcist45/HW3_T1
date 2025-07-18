package com.barbirms.synthetichumancorestarter.commandModule;

public class ConsoleExecutableTask extends ExecutableTask {
    public ConsoleExecutableTask(AndroidCommand androidCommand) {
        super(androidCommand);
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000000000; i++){

        }
        try {
            Thread.sleep(10000);
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
