package com.challengeDisney.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengeDisney.Services.AuthPageService;

import com.challengeDisney.DTO.UserDTO;


@RestController
@RequestMapping("/auth")
public class AuthPage {
	@Autowired
	AuthPageService authPageService;

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDTO user) {
		return authPageService.loginUser(user) ? new ResponseEntity<String>(HttpStatus.OK) : new ResponseEntity<String>("Datos de ingreso incorrectos.", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@ModelAttribute UserDTO user){
		return authPageService.registerUser(user) ? 
				new ResponseEntity<String>("Usuario registrado correctamente", HttpStatus.CREATED) : new ResponseEntity<String>("No se ha podido registrar correctamente.", HttpStatus.BAD_REQUEST);
	}
	
	
}
