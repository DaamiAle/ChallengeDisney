package com.challengeDisney.Characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CharactersService{
	
	@Autowired
	CharactersRepository characterRepository;
	public ArrayList<String> charactersNameList(){
		List<String> namelist = new ArrayList<>();
		return (ArrayList<String>) namelist;
	}
	public ArrayList<CharactersModel> getCharacters(){
		return (ArrayList<CharactersModel>) characterRepository.findAll();
	}
	public CharactersModel saveCharacter(CharactersModel character){
		return characterRepository.save(character);
	}
	public Optional<CharactersModel> getById(Long id){
		return characterRepository.findById(id);
	}
	public ArrayList<CharactersModel> getByAge(Long age){
		return characterRepository.findByAge(age);
	}
	public ArrayList<CharactersModel> getByName(String name){
		return characterRepository.findByName(name);
	}
	public boolean deleteCharacter(Long id) {
		boolean okAction;
		try {
			characterRepository.deleteById(id);
			okAction = true;
		}
		catch(Exception err){
			okAction = false;
		}
		return okAction;
	}
	
}
