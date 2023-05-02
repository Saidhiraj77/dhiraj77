package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;


public interface TheatreDAO {

    public String QUERY_GET_ALL_THEATRES="SELECT theatreId,theatreName FROM theatre";
    public String QUERY_FIND_THEATRE_BY_ID="SELECT theatreId,theatreName FROM theatre t WHERE t.theatreId=?";
    public String QUERY_ADD_NEW_THEATRE="INSERT INTO theatre(theatreId,theatreName) VALUES (?,?)";
    
    public String QUERY_MODIFY_THEATRE_BY_ID ="UPDATE theatre SET theatreName =? WHERE theatreId=?";
    public String QUERY_DELETE_THEATRE_BY_ID ="DELETE FROM theatre WHERE theatreId= ?";
    
    public String QUERY_GET_ALL_MOVIES_IN_THEATRE ="  select mov.theatreId, mov.movieId , mov.movieName from movie mov\r\n"
    		+ "    where mov.theatreId\r\n"
    		+ "    IN (select th.theatreId from theatre th\r\n"
    		+ "    where th.theatreId = ?);";
  
    
    public List<Theatre> getAllTheatres();
    public Theatre findTheatreByID(Long id);
    public boolean createNewTheatre(Theatre theatre);
    public int update(Theatre theatre);
    public int delete(Long id);
    public List<Movie> getAllMovieByTheatre(Long id);
   
}
