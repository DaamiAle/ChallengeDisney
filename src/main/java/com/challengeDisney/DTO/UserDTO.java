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
	
	public UserModel convertToUserModel() {
//		return new UserModel(null, this.userName, this.password, this.name, this.userEmail, null);
		UserModel userEntity = new UserModel();
		userEntity.setUserName(this.userName);
		userEntity.setPassword(this.password);
		userEntity.setName(this.name);
		userEntity.setUserEmail(this.userEmail);
		return userEntity;
	}
}
