package com.challengeDisney.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.UserModel;
import com.challengeDisney.Repositories.UserRepository;


@Service
public class UserServiceDetails implements UserDetailsService{
	@Autowired
	UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	
	public UserModel saveUser(UserModel user){
		String userPassword = user.getPassword();
		user.setPassword(bCryptEncoder.encode(userPassword));
		return userRepo.saveAndFlush(user);
	}
	
	public boolean deleteUser(String userName) {
		boolean okAction;
		try {
			UserModel user = userRepo.findByUserName(userName);
			userRepo.delete(user);
			okAction = true;
		}
		catch(Exception err){
			okAction = false;
		}
		return okAction;
	}

	public Optional<UserModel> getById(Long id) {
		return userRepo.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepo.findByUserName(username);
		return (UserDetails) user;
	}

	public boolean validate(UserDTO user) {
		UserModel userModel = userRepo.findByUserName(user.getUserName());
		return userModel.getUserName().equals(user.getUserName()) && userModel.getPassword().equals(user.getPassword());
		
	}
}
