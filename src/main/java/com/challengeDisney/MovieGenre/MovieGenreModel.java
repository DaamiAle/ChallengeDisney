package com.challengeDisney.MovieGenre;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.challengeDisney.Movies.MovieModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "movieGenre")
public class MovieGenreModel {
	@Id
	@SequenceGenerator(name = "sequenceGenre",sequenceName = "sequenceGenre",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenre")
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "moviesGenreModel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MovieModel> moviesModel;

}
