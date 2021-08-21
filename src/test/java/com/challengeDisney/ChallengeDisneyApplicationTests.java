package com.challengeDisney;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.Role;
import com.challengeDisney.Models.UserModel;
import com.challengeDisney.Services.UserService;

//import com.challengeDisney.Models.CharactersModel;
//import com.challengeDisney.Models.MovieModel;
//import com.challengeDisney.Models.UserModel;
//import com.challengeDisney.Repositories.UserRepository;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ChallengeDisneyApplicationTests {
	@Autowired
	private UserService userService;
	@Test
	public void rellenarTabla() {
		
		System.out.println("Creando usuarios y roles.");
		// Roles
		userService.saveRole(new Role(null,"ROLE_ADMIN"));
		userService.saveRole(new Role(null,"ROLE_MODER"));
		userService.saveRole(new Role(null,"ROLE_MANAGER"));
		userService.saveRole(new Role(null,"ROLE_USER"));
		
		// Usuarios
		UserModel userReturn = userService.saveUser(new UserDTO("DaamiAle", "DaamiAle", "Damian Bruque", "daamiale.recoil@gmail.com"));
		
		userService.addRoleToUser("DaamiAle", "ROLE_ADMIN");
		assertTrue(userReturn.getPassword().equalsIgnoreCase("DaamiAle"));
	}
	
	
//	@Autowired
//	BCryptPasswordEncoder bCryptEncoder;
//	
//	@Autowired
//	UserRepository userRepo;
//	
//	@Test
//	public void crearUsuario() {
//		UserModel user = new UserModel();
//		user.setUserName("ReCoil");
//		user.setPassword(bCryptEncoder.encode("1234"));
//		UserModel userReturn = userRepo.saveAndFlush(user);
//		assertTrue(userReturn.getPassword().equalsIgnoreCase(user.getPassword()));
//	}
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
