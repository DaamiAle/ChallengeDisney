package com.challengeDisney.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challengeDisney.Models.MovieGenreModel;

public interface MovieGenreRepository extends JpaRepository<MovieGenreModel, Long>{

}
