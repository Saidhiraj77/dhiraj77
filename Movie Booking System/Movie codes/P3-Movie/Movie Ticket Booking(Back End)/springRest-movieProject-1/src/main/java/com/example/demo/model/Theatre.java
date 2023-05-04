package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

	private Long theatreId;
	private String theatreName;
	private List movieList;  
	

    public Theatre() {
        movieList=new ArrayList();
    }
 
	public Theatre(Long theatreId, String theatreName, List movieList) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.movieList = movieList;
	}

	public Long getTheatreId() {
		return theatreId;
	}


	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}


	public String getTheatreName() {
		return theatreName;
	}


	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}


	public List getMovieList() {
		return movieList;
	}


	public void setMovieList(List movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", movieList=" + movieList + "]";
	}
    

	
}
