package com.challengeDisney.RestControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengeDisney.Services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userServ;

	@GetMapping
	public String userPage() {
		return "ESTA ES LA PAGINA DE USUARIOS";
	}
}
