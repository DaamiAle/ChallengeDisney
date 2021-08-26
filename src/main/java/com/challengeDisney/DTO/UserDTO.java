package com.challengeDisney.DTO;

import com.challengeDisney.Models.UserModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserDTO {
	private String userName;
	private String password;
	private String name;
	private String userEmail;
	
	public UserModel convertToUserModel() {
		UserModel userEntity = new UserModel();
		userEntity.setUserName(this.userName);
		userEntity.setPassword(this.password);
		userEntity.setName(this.name);
		userEntity.setUserEmail(this.userEmail);
		return userEntity;
	}
}






