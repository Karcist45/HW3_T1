package com.barbirms.synthetichumancorestarter;

import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args){
        ExecutorService executor = Executors.newFixedThreadPool(2);

    }
}
