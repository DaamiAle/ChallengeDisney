package com.challengeDisney.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CharacterDTO {
	private Long id;
	private String imageUrl;
	private String name;
}
