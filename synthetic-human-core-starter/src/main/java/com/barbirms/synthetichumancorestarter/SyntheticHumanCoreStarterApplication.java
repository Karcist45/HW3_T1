package com.barbirms.synthetichumancorestarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SyntheticHumanCoreStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyntheticHumanCoreStarterApplication.class, args);
	}

}
