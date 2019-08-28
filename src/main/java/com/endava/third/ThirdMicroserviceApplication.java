package com.endava.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThirdMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdMicroserviceApplication.class, args);
	}

}
