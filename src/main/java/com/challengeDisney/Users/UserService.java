package com.challengeDisney.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService{
	@Autowired
	UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	
	public UserModel saveUser(UserModel user){
		String userPassword = user.getPassword();
		user.setPassword(bCryptEncoder.encode(userPassword));
		return userRepo.save(user);
	}
	
	public boolean deleteUser(Long id) {
		boolean okAction;
		try {
			userRepo.deleteById(id);
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
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(user.getUserRol().getRolName()));
		UserDetails userDet = new User(user.getUserName(),user.getPassword(),roles);
		return userDet;
	}

}
