package com.challengeDisney.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDTO {
	private Long id;
	private String userName;
	private String password;
	private String name;
	private String userEmail;
}
