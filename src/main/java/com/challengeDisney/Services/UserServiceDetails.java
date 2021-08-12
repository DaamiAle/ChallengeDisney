package com.challengeDisney.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.UserModel;
import com.challengeDisney.Repositories.UserRepository;


@Service
public class UserServiceDetails implements UserDetailsService{
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		
		
		return null;
//		UserModel userEntity = new UserModel();
//		if (username != null) {
//			userEntity = userRepo.findByUserName(username);
//		}
//		String userEntityName = userEntity.getUserName();
//		String userEntityPassword = userEntity.getPassword();
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		userEntity.getRoles().forEach(rol -> {
//			authorities.add( rol.getAuthoritie()); 
//		});
//		User userReturn = new User(userEntityName,userEntityPassword,authorities);
//		return (userEntity != null) ? userReturn : null;
	}

	public UserModel createUser(UserDTO user) {
		UserModel userEntity = user.convertToUserModel();
		return userRepo.saveAndFlush(userEntity);
	}
	
	
}
