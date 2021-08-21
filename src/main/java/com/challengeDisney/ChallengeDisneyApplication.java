package com.challengeDisney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication //(exclude = { SecurityAutoConfiguration.class }) 
public class ChallengeDisneyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChallengeDisneyApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}