package com.challengeDisney.Movies;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	public ArrayList<MovieModel> getMovies(){
		return (ArrayList<MovieModel>) movieRepository.findAll();
	}
}
