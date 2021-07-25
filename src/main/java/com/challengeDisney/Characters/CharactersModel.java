package com.challengeDisney.Characters;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.challengeDisney.Movies.MovieModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "characters")
public class CharactersModel {
	@Id
	@SequenceGenerator(name = "sequenceCharacter",sequenceName = "sequenceCharacter",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCharacter")
	private Long id;
	private String name;
	private Long age;
	private float weigth;
	private String story;

	@ManyToMany(mappedBy = "charactersModel")
	private List<MovieModel> moviesModel;
}
