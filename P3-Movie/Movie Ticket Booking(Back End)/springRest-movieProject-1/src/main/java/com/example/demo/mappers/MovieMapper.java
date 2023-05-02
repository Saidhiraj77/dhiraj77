package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Movie;

public class MovieMapper implements RowMapper<Movie>{

    /*implement abstract method for declaring mapping
    *between POJO attributes and relational table attributes
    */
   public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
       Movie movie=new Movie();
       movie.setMovieId(rs.getLong("movieId"));
       movie.setMovieName(rs.getString("movieName"));
       movie.setNoOfTickets(rs.getLong("noOfTickets"));
       movie.setTheatreId(rs.getLong("theatreId"));
       movie.setImage(rs.getBytes("image"));                                
       movie.setTheatreName(rs.getString("theatreName"));
       return movie;
   }
}