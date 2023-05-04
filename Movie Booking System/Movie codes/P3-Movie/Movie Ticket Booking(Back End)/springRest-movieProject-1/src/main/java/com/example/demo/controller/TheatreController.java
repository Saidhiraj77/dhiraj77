package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TheatreDAOImpl;
import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"}, allowedHeaders = "*")
public class TheatreController {

	@Autowired
	private TheatreDAOImpl td;
	
	@PostMapping("/theatre")
	public boolean addTheatre(@RequestBody Theatre theatre)
	{
		return td.createNewTheatre(theatre);
	}
	
	@GetMapping("/theatre")
	public List<Theatre> getAllTheatre()
	{
		return td.getAllTheatres();
	}
	
	@GetMapping("/theatre/{id}")
	public Theatre findTheatreById(@PathVariable("id") Long id)
	{
		return td.findTheatreByID(id);
	}
	
	@PutMapping("/theatre")
	public int modifyTheatre(@RequestBody Theatre theatre)
	{
		return td.update(theatre);
	}
	
	@DeleteMapping("/theatre/{id}")
	public int removeTheatre(@PathVariable("id") Long id)
	{
		return td.delete(id);
	}
	@GetMapping("/theatre/movies/{id}")
	public List<Movie> getAllMoviesByTheatre(@PathVariable("id") Long id)
	{
		return td.getAllMovieByTheatre(id);
	
	}
}
