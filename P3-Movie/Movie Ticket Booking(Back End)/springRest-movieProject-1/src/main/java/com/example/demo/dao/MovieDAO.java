package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;

public interface MovieDAO {

    public String QUERY_CREATE_NEW_MOVIE="INSERT INTO movie(movieId,movieName,noOfTickets,theatreId,image) VALUES (?,?,?,?,?)";   

    public String QUERY_GET_MOVIES_OF_THEATRE="SELECT  mov.movieId AS `movieId`,   mov.movieName AS `movieName`, mov.noOfTickets AS `noOfTickets`,  th.theatreId AS `theatreId`"
    		+ "                   			  FROM  theatre th  INNER JOIN movie mov"
    		+ "                               ON th.theatreId = mov.theatreId WHERE  th.theatreId = ?";
    public String QUERY_DELETE_MOVIE_BY_ID ="DELETE FROM movie WHERE movieId= ?";
    public String QUERY_GET_MOVIE_BY_ID ="SELECT mov.movieId AS `movieId`, mov.movieName AS `movieName`,  mov.noOfTickets AS `noOfTickets`, mov.theatreId AS `theatreId`, mov.image AS image, t.theatreName AS `theatreName`\r\n"
    		+ " FROM movie mov  JOIN theatre t ON mov.theatreId = t.theatreId WHERE movieId=?";
    public String QUERY_GET_All_MOVIES ="SELECT m.movieId ,m.movieName, m.noOfTickets, m.theatreId, m.image, t.theatreName FROM movie m  JOIN theatre t ON m.theatreId = t.theatreId ";
    public String QUERY_MODIFY_MOVIE_ID ="UPDATE movie SET movieName=?, noOfTickets=? ,theatreId=? WHERE movieId=?";
    public String QUERY_MODIFY_MOVIE_ID_PIC ="UPDATE movie SET movieName=?, noOfTickets=? ,theatreId=?, image=? WHERE movieId=?"; 

    public String QUERY_GET_ALL_THEATRES_BY_MOVIE ="";
    public String QUERY_GET_MOVIE_BY_NAMEE ="SELECT * FROM movie WHERE movieName= ? ";
    public String QUERY_GET_MOVIE_BY_NAME ="  SELECT m.movieId ,m.movieName, m.noOfTickets, m.theatreId, m.image, t.theatreName \r\n"
     		+ "    FROM movie m  JOIN theatre t ON m.theatreId = t.theatreId WHERE movieName= ? ";
    
    public String QUERY_GET_MOVIE_BY_THEATRE_NAME = "SELECT m.movieId ,m.movieName, m.noOfTickets, m.theatreId, m.image, t.theatreName \r\n"
            + "    FROM movie m  JOIN theatre t ON m.theatreId = t.theatreId WHERE theatreName= ? ";
  
    		
    public List<Movie> getMoviesOfTheatre(Theatre theatre);  
    public boolean createNewMovie(Movie mov);
    public boolean deleteMovieById(Long id);
    public Movie getMovieById(Long id);
    public List<Movie> getAllMovies();
    public int modifyMovie(Movie movie);
    public List<Movie> getAllTheatresByMovie(Long id); 
    public List<Movie> getMovieByName(String moviename);
    public List<Movie> getMovieBytheatreName(String theatrename) ;

}

