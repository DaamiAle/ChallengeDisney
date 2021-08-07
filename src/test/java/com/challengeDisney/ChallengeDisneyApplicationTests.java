package com.challengeDisney;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

//import com.challengeDisney.Models.CharactersModel;
//import com.challengeDisney.Models.MovieModel;
import com.challengeDisney.Models.UserModel;
import com.challengeDisney.Repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChallengeDisneyApplicationTests {
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	public void crearUsuario() {
		UserModel user = new UserModel();
		user.setUserName("ReCoil");
		user.setPassword(bCryptEncoder.encode("1234"));
		UserModel userReturn = userRepo.saveAndFlush(user);
		assertTrue(userReturn.getPassword().equalsIgnoreCase(user.getPassword()));
	}
/*
	@Autowired
	private CharactersRepository characterRepo;
	
	@Test
	public void crearPersonaje() {
		CharactersModel character = new CharactersModel();
		MovieModel movie = new MovieModel();
		movie.setMovieTitle("Spider-Man: Home Comming");
		movie.setCreationDate(null);
		movie.setMovieValoration((long)1);
		character.setAge((long)15);
		character.setName("SpiderMan");
		character.setWeigth((float)65.8);
		character.setStory("Peter Parker tras ser mordido por una araña geneticamente modificada, adquiere increibles poderes. Decide convertirse en un heroe, Spider-Man");
		character.getMovies().add(movie);
		
		
	}*/
}
