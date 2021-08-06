package com.challengeDisney.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "movies")
public class MovieModel {
	@Id
	@SequenceGenerator(name = "seqMovie",sequenceName = "seqMovie",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMovie")
	private Long id;
	private String imageUrl;
	@Column(unique = true) @NotNull
	private String movieTitle;
	private Date creationDate;
	private Long movieValoration;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
	        name = "movie_character",
	        joinColumns = @JoinColumn(name = "movie_id", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="character_id", nullable = false)
	        )
	private List<CharactersModel> characters;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "movieGen_id")
	private MovieGenreModel movieGen;

	
}
