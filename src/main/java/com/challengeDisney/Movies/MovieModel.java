package com.challengeDisney.Movies;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.challengeDisney.Characters.CharactersModel;
import com.challengeDisney.MovieGenre.MovieGenreModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "movies")
public class MovieModel {
	@Id
	@SequenceGenerator(name = "sequenceMovie",sequenceName = "sequenceMovie",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceMovie")
	private Long id;
	private String movieTitle;
	private Date creationDate;
	private Long movieScore;
	@JoinTable(
	        name = "movie_character",
	        joinColumns = @JoinColumn(name = "id_movie", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="id_character", nullable = false)
	        )
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CharactersModel> charactersModel;
	
	@ManyToOne
    @JoinColumn(name = "id_movieGenre")
	private MovieGenreModel moviesGenreModel;
	
}
