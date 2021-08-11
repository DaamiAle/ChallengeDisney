package com.challengeDisney.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengeDisney.Services.UserServiceDetails;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceDetails userServiceDet;
	
	@GetMapping
	public String userPage() {
		return "ESTA ES LA PAGINA DE USUARIOS";
	}
}
