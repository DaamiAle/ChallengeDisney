package com.challengeDisney.RestControllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challengeDisney.Services.AuthPageService;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.UserModel;


@RestController
@RequestMapping("/auth")
public class AuthPageController {
	@Autowired
	AuthPageService authPageService;
	
	@GetMapping("/login")
	public String loginPage() {
		return "ESTA ES LA PAGINA DE LOGIN";
	}
	@GetMapping
	public String authPage() {
		return "ESTA ES LA PAGINA DE AUTENTICACION";
	}

//	@PostMapping("/login")
//	public String loginUser(@RequestBody UserDTO user) {
//		return authPageService.loginUser(user) ? "redirect:/user" : "Datos de ingreso incorrectos.";
//	}
	
	@PostMapping("/register")
	public ResponseEntity<UserModel> registerUser(@RequestBody UserDTO user){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/register").toUriString());
		return ResponseEntity.created(uri).body(authPageService.registerUser(user));
	}
	
	
//	@PostMapping("/register")
//	public String registerUser(@ModelAttribute UserDTO user){
//		return authPageService.registerUser(user) ? 
//				"Usuario registrado correctamente" : "No se ha podido registrar correctamente.";
//	}
	
	
}
