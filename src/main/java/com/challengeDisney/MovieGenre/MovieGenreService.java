package com.challengeDisney.MovieGenre;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MovieGenreService{
	
	@Autowired
	private MovieGenreRepository genreRepository;
	
	public ArrayList<MovieGenreModel> getMovieGenre(){
		return (ArrayList<MovieGenreModel>) genreRepository.findAll();
	}
	
}
