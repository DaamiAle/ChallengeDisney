package com.challengeDisney.Characters;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharactersRepository extends JpaRepository<CharactersModel, Long>{
	public abstract ArrayList<CharactersModel> findByName(String name);
	public abstract ArrayList<CharactersModel> findByAge(Long age);
	
}
