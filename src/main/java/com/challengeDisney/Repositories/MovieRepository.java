package com.challengeDisney.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengeDisney.Models.MovieModel;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long>{

}
