package com.challengeDisney.RestControllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challengeDisney.Models.Role;
import com.challengeDisney.Models.UserModel;
import com.challengeDisney.Services.UserService;
import com.challengeDisney.DTO.RoleToUserForm;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	private final UserService userServ;
	
	@GetMapping("/newRole")
	public String createRole() {
		return "ESTA ES LA PAGINA DE CREACION DE ROLES";
	}
	@PostMapping("/newRole")
	public ResponseEntity<Role> createRole(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/newRole").toUriString());
		return ResponseEntity.created(uri).body(userServ.saveRole(role));
	}
	@PostMapping("/addRoleToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
		userServ.addRoleToUser(form.getUserName(), form.getRolName());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/usersList")
	public ResponseEntity<List<UserModel>> getUsers(){
		return ResponseEntity.ok().body(userServ.getUsers());
	}
	
	
	
	

	
}
