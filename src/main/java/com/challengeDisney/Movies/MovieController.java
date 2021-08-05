package com.challengeDisney.Movies;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@PostMapping("/save")
	public MovieModel saveMovie(@RequestBody MovieModel movie) {
		return movieService.saveMovie(movie);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteMovie(@PathVariable("id") Long id) {
		boolean okDeletion = movieService.deleteMovie(id);
		return (okDeletion) ? "Se elimino correctamente el personaje con id: " + id.toString() : "No se pudo eliminar el personaje con id: " + id.toString() ;
	}
	
	@GetMapping
	public ArrayList<?> moviesList(	@RequestParam (required=false, name="name"	) 	String 	name, 
											@RequestParam (required=false, name="genre"	) 	Long 	genreId, 
											@RequestParam (required=false, name="order"	) 	String 	order,
											@RequestParam (required=false, name="score"	)	Long 	score){ 
		return movieService.getMoviesBy(name,genreId,order,score);
	}
	
	@GetMapping("/{id}")
	public Optional<MovieModel> movieDetails(@PathVariable("id") Long id){
		return movieService.getById(id);
	}
}
