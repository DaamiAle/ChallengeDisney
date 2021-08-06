package com.challengeDisney.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengeDisney.DTO.CharacterDTO;
import com.challengeDisney.Models.CharactersModel;
import com.challengeDisney.Repositories.CharactersRepository;

@Service
public class CharactersService{
	
	@Autowired
	CharactersRepository characterRepository;
	
	public ArrayList<CharacterDTO>getCharactersBy(String name, Long age, Long movieId, Float weigth){
		ArrayList<CharactersModel> charList = (ArrayList<CharactersModel>) characterRepository.findAll();
		if (name != null) {
			charList.stream().filter(character -> character.getName().equalsIgnoreCase(name)).toArray();
		}
		if (age != null) {
			charList.stream().filter(character -> character.getAge().equals(age)).toArray();
		}
		if (movieId != null) {
			charList.stream().filter(character -> character.getMovies().stream().filter(movie -> movie.getId().equals(movieId)).count() == (long) 1 ).toArray();
		}
		if (weigth != null) {
			charList.stream().filter(character -> character.getWeigth().equals(weigth)).toArray();
		}
		ArrayList<CharacterDTO> finalListChar = new ArrayList<>();
		charList.forEach(character -> {
			CharacterDTO characterDto = new CharacterDTO(character.getId(), character.getImageUrl(), character.getName());
			finalListChar.add(characterDto);
		});
		return finalListChar;
	}
	
	public CharactersModel saveCharacter(CharactersModel character){
		return characterRepository.saveAndFlush(character);
	}
	public Optional<CharactersModel> getById(Long id){
		return characterRepository.findById(id);
	}
	public boolean deleteCharacter(Long id) {
		boolean availableDeletion;
		try {
			characterRepository.deleteById(id);
			availableDeletion = true;
		}
		catch (Exception e) {
			availableDeletion = false;
		}
		return availableDeletion;
	}
	
}
