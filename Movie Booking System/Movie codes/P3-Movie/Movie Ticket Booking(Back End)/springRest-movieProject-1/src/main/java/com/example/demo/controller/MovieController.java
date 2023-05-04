package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.dao.MovieDAOImpl;
import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"}, allowedHeaders = "*")
public class MovieController {

	@Autowired
	MovieDAOImpl  md;
	
	@PostMapping("/movie")                                                    
	public boolean addMovie(@RequestParam Long movieId, @RequestParam String movieName, @RequestParam Long noOfTickets, @RequestParam Long theatreId,@RequestParam("image") MultipartFile file) throws IOException
	{
		byte[] image = file.getBytes();
		Movie movie = new Movie(movieId, movieName,theatreId,noOfTickets, image);
		return md.createNewMovie(movie);
	}
	@PutMapping("/movie")                                                    
	public int updateMovie(@RequestParam Long movieId, @RequestParam String movieName, @RequestParam Long noOfTickets, @RequestParam Long theatreId,@RequestParam("image") MultipartFile file) throws IOException
	{
		byte[] image = file.getBytes();
		Movie movie = new Movie(movieId, movieName,theatreId,noOfTickets, image);
		return md.modifyMovie(movie);
	}
	
	@PutMapping("/movie/tickets")
	public int updateMovie(@RequestBody Movie movie)
	{
		return md.modifyMovie(movie);
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable("id") Long id)
	{
		return md.getMovieById(id);
	}
	
	@GetMapping("/movie/movie/{moviename}")
	public List<Movie> getMovieByName(@PathVariable("moviename") String moviename)
	{
		return md.getMovieByName(moviename);
	}
	
	@GetMapping("/movie/theatre/{theatrename}")
	public List<Movie> getMovieBytheatreName(@PathVariable("theatrename") String theatrename)
	{
		return md.getMovieBytheatreName(theatrename);
	}
	
	@GetMapping("/movie")
	public List<Movie> getAllMovies()
	{
		return md.getAllMovies();
	}
	
	@GetMapping("/movie/{theatre_id}/{theatre_name}")
	public List<Movie> getAllMoviesByTheatre(@PathVariable("theatre_id") Long id, @PathVariable("theatre_name") String name)
	{
		Theatre theatre = new Theatre();
		theatre.setTheatreId(id);
		theatre.setTheatreName(name);
		return md.getMoviesOfTheatre(theatre);
	}
	
	@GetMapping("/movie/theatres/{movie_Id}")
	public List<Movie> getAllTheatresByMovie(@PathVariable("movie_Id") Long id)
	{
		return md.getAllTheatresByMovie(id);
	}
	
	@DeleteMapping("/movie/{id}")
	public boolean deleteMovieById(@PathVariable("id") Long id)
	{
		return md.deleteMovieById(id);
	}
	
}
