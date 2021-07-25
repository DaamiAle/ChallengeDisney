package com.challengeDisney;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.challengeDisney.Users.UserModel;
import com.challengeDisney.Users.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChallengeDisneyApplicationTests {
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	private UserRepository userRepo;
	@Test
	public void crearUsuario() {
		UserModel user = new UserModel();
		user.setUserName("ReCoil");
		user.setPassword(bCryptEncoder.encode("1234"));
		UserModel userReturn = userRepo.save(user);
		assertTrue(userReturn.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
