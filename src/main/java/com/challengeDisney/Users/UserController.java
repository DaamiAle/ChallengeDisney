package com.challengeDisney.Users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userServ;
	
	@GetMapping
	public String userPage() {
		return "userPage";
	}
	@GetMapping("/{id}")
	public Optional<UserModel> userDetails(Long id){
		return this.userServ.getById(id);
	}
	@PostMapping("/save")
	public UserModel saveUser(@RequestBody UserModel user) {
		return this.userServ.saveUser(user);
	}
}
