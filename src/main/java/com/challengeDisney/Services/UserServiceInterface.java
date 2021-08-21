package com.challengeDisney.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.challengeDisney.DTO.UserDTO;
import com.challengeDisney.Models.Role;
import com.challengeDisney.Models.UserModel;

public interface UserServiceInterface extends UserDetailsService{
	UserModel saveUser(UserDTO user);
	UserModel getUser(String userName);
	List<UserModel> getUsers();
	Role saveRole(Role role);
	void addRoleToUser(String userName,String roleName);
}
