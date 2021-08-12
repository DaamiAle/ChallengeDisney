package com.challengeDisney;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.challengeDisney.Models.Role;
import com.challengeDisney.Services.UserServiceInterface;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = { SecurityAutoConfiguration.class }) 
public class ChallengeDisneyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChallengeDisneyApplication.class, args);
	}
	
	CommandLineRunner run(UserServiceInterface userService) {
		return args -> {
			// Roles
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_MODER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_USER"));
			
			// Usuarios
			userService.saveUser(new UserDTO());
		};
	}
		
}