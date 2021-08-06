package com.challengeDisney.Security;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Services.UserServiceDetails;

@RestController
@RequestMapping("/auth")
public class AuthPage {
	@Autowired
	UserServiceDetails userService;
	/*
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDTO user) {
		return userService.validate(user) ? new ResponseEntity<String>(HttpStatus.OK) : new ResponseEntity<String>("Datos de ingreso incorrectos.", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(path = "/{userName}")
	public ResponseEntity<String> deleteUser(@PathVariable("userName") String userName) {
		boolean okDeletion = userService.deleteUser(userName);
		return (okDeletion) ? new ResponseEntity<String>("Se elimino correctamente el usuario.", HttpStatus.OK) : new ResponseEntity<String>("No se pudo eliminar el usuario.", HttpStatus.BAD_REQUEST);
	}
	*/
}
