package com.challengeDisney.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

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
			userRepo.deleteById(userName);
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
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepo.findByUserName(username);
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		user.getUserRol().forEach(rol -> roles.add(new SimpleGrantedAuthority(rol)));
		//roles.addAll(new SimpleGrantedAuthority(user.getUserRol()));
		UserDetails userDet = new User(user.getUserName(),user.getPassword(),roles);
		return userDet;
	}
	*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepo.findByUserName(username);
		
		return null;
	}
}
