package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class Movie {
	
	private Long movieId;
	private String movieName;

	private Long theatreId;
	private Long noOfTickets;
	private byte[] image;                                                      
	private String theatreName;

	public Movie() {
	}
	

	public Movie(Long movieId, String movieName, Long theatreId, Long noOfTickets, byte[] image) {   
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.theatreId = theatreId;
		this.noOfTickets = noOfTickets;
		this.image = image;
	}
	public Movie(Long movieId, String movieName, Long theatreId, Long noOfTickets) {     
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.theatreId = theatreId;
		this.noOfTickets = noOfTickets;
	}

	
	public byte[] getImage() {                    
		return image;
	}

	public void setImage(byte[] image) {              
		this.image = image;
	}

	public Long getMovieId() {
		return movieId;
	}

	
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}

	public Long getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(Long noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	
 
	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	@Override                                                              
	public String toString() {                           
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", theatreId=" + theatreId + ", noOfTickets="
				+ noOfTickets + ", image=" + Arrays.toString(image) + "]";
	}

	
}
