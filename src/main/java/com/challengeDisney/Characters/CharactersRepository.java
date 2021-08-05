package com.challengeDisney.Characters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharactersRepository extends JpaRepository<CharactersModel, Long>{
	
}
