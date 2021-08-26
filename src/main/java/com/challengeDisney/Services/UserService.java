package com.challengeDisney.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.Role;
import com.challengeDisney.Models.UserModel;
import com.challengeDisney.Repositories.RoleRepository;
import com.challengeDisney.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor @Transactional 
public class UserService implements UserServiceInterface{
	
	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserModel saveUser(UserDTO user) {
		System.out.printf("Guardando usuario %s en base de datos.", user.getName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.saveAndFlush(user.convertToUserModel());
	}

	@Override
	public UserModel getUser(String userName) {
		System.out.printf("Obteniendo usuario %s de la base de datos.", userName);
		return userRepo.findByUserName(userName);
	}

	@Override
	public List<UserModel> getUsers() {
		System.out.print("Obteniendo usuarios de la base de datos.");
		return userRepo.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		System.out.printf("Guardando rol %s en base de datos.", role.getName());
		return roleRepo.saveAndFlush(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		UserModel user = userRepo.findByUserName(userName);
		Role role = roleRepo.findByName(roleName);
		System.out.printf("Agregando rol %s al usuario %s.",roleName, userName);
		user.getRoles().add(role);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserModel user = userRepo.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new User(user.getUserName(), user.getPassword(), authorities);
	}
	
}
