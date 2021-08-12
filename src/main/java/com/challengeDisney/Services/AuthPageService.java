package com.challengeDisney.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.UserModel;

@Service
public class AuthPageService {
	
	private BCryptPasswordEncoder bCriptEncoder;
	@Autowired
	UserService userServ;

	public boolean loginUser(UserDTO user) {
		boolean okAction = false;
		UserDetails userDet = userServ.loadUserByUsername(user.getUserName());
		if (userDet != null) {
			String userPassword = bCriptEncoder.encode(user.getPassword());
			okAction = userDet.getPassword().equalsIgnoreCase(userPassword);
		}
		return okAction;
	}

	public UserModel registerUser(UserDTO user) {
		String userPassword = bCriptEncoder.encode(user.getPassword());
		user.setPassword(userPassword);
		return userServ.saveUser(user);
	}
	
	
	
	
}
