package com.challengeDisney.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.challengeDisney.DTO.MovieDTO;
import com.challengeDisney.Models.MovieModel;
import com.challengeDisney.Repositories.MovieRepository;

@Service
public class MovieService{
	@Autowired
	MovieRepository movieRepository;
	
	public MovieModel saveMovie(MovieModel movie) {
		return movieRepository.saveAndFlush(movie);
	}
	
	public ArrayList<?> getMoviesBy(String title, Long genreId, String order, Long score) {
		ArrayList<MovieModel> moviesList = new ArrayList<>();
		ArrayList<MovieDTO> finalListMovies = new ArrayList<>();
		if (order.equalsIgnoreCase("ASC") || order.equalsIgnoreCase("DESC")) {
			Sort.Direction direction = order.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC ;
			moviesList = (ArrayList<MovieModel>) movieRepository.findAll(Sort.by(direction, "creationDate"));
		}
		else {
			moviesList = (ArrayList<MovieModel>) movieRepository.findAll();
		}
		if (title != null) {
			moviesList.stream().filter(movie -> movie.getMovieTitle().equalsIgnoreCase(title)).toArray();
		}
		if (genreId != null) {
			moviesList.stream().filter(movie -> movie.getMovieGen().getId() == genreId).toArray();
		}
		if (score != null) {
			moviesList.stream().filter(movie -> movie.getMovieValoration() == score).toArray();
		}
		moviesList.forEach(movie -> {
			MovieDTO movieDto = new MovieDTO(movie.getId(), movie.getImageUrl(), movie.getMovieTitle(),movie.getCreationDate());
			finalListMovies.add(movieDto);
		});
		return finalListMovies;
	}
	
	public boolean deleteMovie(Long id) {
		boolean availableDeletion;
		try {
			movieRepository.deleteById(id);
			availableDeletion = true;
		}
		catch (Exception e) {
			availableDeletion = false;
		}
		return availableDeletion;
	}

	public Optional<MovieModel> getById(Long id) {
		return movieRepository.findById(id);
	}
}
