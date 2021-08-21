package com.challengeDisney.RestControllers;

//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.challengeDisney.Models.UserModel;

//import com.challengeDisney.Services.UserServiceInterface;
//
//import lombok.RequiredArgsConstructor;

import com.challengeDisney.Services.UserService;

import lombok.RequiredArgsConstructor;
//import com.challengeDisney.Services.UserServiceDetails;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userServ;
	
	
	
	
//	
//	@GetMapping
//	public String userPage() {
//		return "ESTA ES LA PAGINA DE USUARIOS";
//	}
}
