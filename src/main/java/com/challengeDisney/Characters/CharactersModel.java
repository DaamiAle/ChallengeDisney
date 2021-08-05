package com.challengeDisney.Characters;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.challengeDisney.Movies.MovieModel;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "characters")
public class CharactersModel {
	@Id
	@SequenceGenerator(name = "seqChar",sequenceName = "seqChar",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqChar")
	private Long id;
	private String imageUrl;
	@Column(unique = true) @NotNull
	private String name;
	private Long age;
	private Float weigth;
	private String story;
	@ManyToMany(mappedBy = "characters")
	private List<MovieModel> movies;
}
