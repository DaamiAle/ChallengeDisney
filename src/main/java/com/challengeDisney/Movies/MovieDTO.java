package com.challengeDisney.Movies;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class MovieDTO {
	private Long id;
	private String imageUrl;
	private String movieTitle;
	private Date creationDate;

}
