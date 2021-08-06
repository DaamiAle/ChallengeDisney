package com.challengeDisney.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengeDisney.Models.CharactersModel;


@Repository
public interface CharactersRepository extends JpaRepository<CharactersModel, Long>{
	
}
