package com.challengeDisney.Roles;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server/administration")
public class RolController {
	@Autowired
	RolService rolServ;
	
	@GetMapping("/roles")
	public ArrayList<RolModel> rolesList(){
		return rolServ.getRoles();
	}
	
	@PostMapping("/createRol")
	public RolModel createRol(@RequestBody RolModel rol) {
		return this.rolServ.createRol(rol);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteCharacter(@PathVariable("id") Long id) {
		boolean okAction = this.rolServ.deleteRol(id);
		String answer = null;
		if (okAction) { answer = "Se elimino correctamente el personaje con id: " + id; }
		else { answer = "No se pudo eliminar el personaje con id: " + id; }
		return answer;
	}
	
}
