package com.challengeDisney.DTO;

import com.challengeDisney.Models.UserModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDTO {
	private String userName;
	private String password;
	private String name;
	private String userEmail;
	
	public UserModel convertToUserModel(UserDTO user) {
		UserModel userEntity = new UserModel();
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setName(user.getName());
		userEntity.setUserEmail(user.getUserEmail());
		return userEntity;
	}
}
