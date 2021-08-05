package com.challengeDisney.MovieGenre;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MovieGenreService{
	
	@Autowired
	private MovieGenreRepository genreRepository;
	
	public MovieGenreModel saveGenre(MovieGenreModel movieGenre) {
		return genreRepository.save(movieGenre);
	}

	public ArrayList<MovieGenreModel> getAllGenres() {
		// TODO Auto-generated method stub
		return null;
	}

	public MovieGenreModel createGenre(MovieGenreModel genre) {
		// TODO Auto-generated method stub
		return null;
	}
}
