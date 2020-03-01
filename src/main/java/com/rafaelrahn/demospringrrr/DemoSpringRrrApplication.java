package com.rafaelrahn.demospringrrr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSpringRrrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringRrrApplication.class, args);
	}

}
