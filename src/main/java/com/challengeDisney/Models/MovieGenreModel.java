package com.challengeDisney.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "movieGenre")
public class MovieGenreModel {
	@Id
	@SequenceGenerator(name = "seqGenre",sequenceName = "seqGenre",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenre")
	private Long id;
	@Column(unique = true) @NotNull
	private String name;
	private String imageUrl;
	@OneToMany(mappedBy = "movieGen")
	private List<MovieModel> movies;

}
