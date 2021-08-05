package com.challengeDisney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) 
public class ChallengeDisneyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChallengeDisneyApplication.class, args);
	}
}
