package com.challengeDisney.Characters;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharactersController {
	@Autowired
	CharactersService characterService;
	
	@GetMapping()
	public ArrayList<String> charactersNameList(){
		return characterService.charactersNameList();
	}
	@GetMapping("/{id}")
	public Optional<CharactersModel> characterDetails(Long id){
		return this.characterService.getById(id);
	}
	@PostMapping("/save")
	public CharactersModel saveCharacter(@RequestBody CharactersModel character) {
		return this.characterService.saveCharacter(character);
	}
	@DeleteMapping(path = "/{id}")
	public String deleteCharacter(@PathVariable("id") Long id) {
		boolean okAction = this.characterService.deleteCharacter(id);
		String answer = null;
		if (okAction) { answer = "Se elimino correctamente el personaje con id: " + id; }
		else { answer = "No se pudo eliminar el personaje con id: " + id; }
		return answer;
	}
}
