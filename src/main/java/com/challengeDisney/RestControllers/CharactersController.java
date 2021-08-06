package com.challengeDisney.RestControllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challengeDisney.DTO.CharacterDTO;
import com.challengeDisney.Models.CharactersModel;
import com.challengeDisney.Services.CharactersService;

@RestController
@RequestMapping("/characters")
public class CharactersController {
	@Autowired
	CharactersService characterService;
	
	@PostMapping("/save")
	public CharactersModel saveCharacter(@RequestBody CharactersModel character) {
		return characterService.saveCharacter(character);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteCharacter(@PathVariable("id") Long id) {
		boolean okDeletion = characterService.deleteCharacter(id);
		return (okDeletion) ? "Se elimino correctamente el personaje con id: " + id.toString() : "No se pudo eliminar el personaje con id: " + id.toString() ;
	}
	
	@GetMapping
	public ArrayList<CharacterDTO> charactersList(	@RequestParam (required=false, name="name"	) 	String 	name, 
													@RequestParam (required=false, name="age"	) 	Long 	age, 
													@RequestParam (required=false, name="movies") 	Long 	movieId,
													@RequestParam (required=false, name="weigth") 	Float 	weigth){ 
		return characterService.getCharactersBy(name,age,movieId,weigth);
	}
	
	@GetMapping("/{id}")
	public Optional<CharactersModel> characterDetails(@PathVariable("id") Long id){
		return characterService.getById(id);
	}
}
