package com.challengeDisney.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.MovieModel;
import com.challengeDisney.Services.UserServiceDetails;

@RestController
@RequestMapping("/auth")
public class AuthPage {
	@Autowired
	UserServiceDetails userService;
	
	@PostMapping("/login")
	public UserDetails saveMovie(@RequestBody UserDTO user) {
		return userService.loadUserByUsername(user.getUserName());
		
	}
	
	@DeleteMapping(path = "/{userName}")
	public String deleteUser(@PathVariable("userName") String userName) {
		boolean okDeletion = userService.deleteUser(userName);
		return (okDeletion) ? "Se elimino correctamente el personaje con id: " + id.toString() : "No se pudo eliminar el personaje con id: " + id.toString() ;
	}
}
