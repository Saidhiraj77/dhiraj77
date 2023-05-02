package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.mappers.MovieMapper;
import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;

@Component
public class MovieDAOImpl implements MovieDAO {

	 private JdbcTemplate jdbcTemplate;

	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	@Override
	public List<Movie> getMoviesOfTheatre(Theatre theatre) {
		System.out.println("Executing : " + QUERY_GET_MOVIES_OF_THEATRE);
        
        List<Movie> movieList=
                this.jdbcTemplate.query(QUERY_GET_MOVIES_OF_THEATRE,
                new MovieMapper(),theatre.getTheatreId());
        
        return movieList;
	}

	@Override
	public boolean createNewMovie(Movie mov) {
        System.out.println("Executing : " + QUERY_CREATE_NEW_MOVIE);
        
        int affectedRows=jdbcTemplate.update(QUERY_CREATE_NEW_MOVIE, 
                mov.getMovieId() ,mov.getMovieName(),mov.getNoOfTickets(),mov.getTheatreId(), mov.getImage());  
        
        return (affectedRows == 1);
	}

	public boolean deleteMovieById(Long id) {
		System.out.println("Executing : " + QUERY_DELETE_MOVIE_BY_ID);
        
        int affectedRows=jdbcTemplate.update(QUERY_DELETE_MOVIE_BY_ID,id);
        
        return (affectedRows == 1);
	}

	public Movie getMovieById(Long id) {
		System.out.println("Executing : " + QUERY_GET_MOVIE_BY_ID);
        
        Movie movie = jdbcTemplate.queryForObject(QUERY_GET_MOVIE_BY_ID, new MovieMapper(),id);
        return movie ;
	}

	public List<Movie> getAllMovies() {
		System.out.println("Executing : " + QUERY_GET_All_MOVIES);
		
		List<Movie> movieList=
                this.jdbcTemplate.query(QUERY_GET_All_MOVIES,
                new MovieMapper());
        return movieList;
	}

	public int modifyMovie(Movie movie) {                                                 
        System.out.println("---------------Entering modify method----------------------");

         if(movie.getImage().length>0) {
          System.out.println("Executing : " + QUERY_MODIFY_MOVIE_ID);
         return jdbcTemplate.update(QUERY_MODIFY_MOVIE_ID_PIC, movie.getMovieName(),movie.getNoOfTickets(), movie.getTheatreId(),movie.getImage(), movie.getMovieId());
         }
    return jdbcTemplate.update(QUERY_MODIFY_MOVIE_ID, movie.getMovieName(),movie.getNoOfTickets(), movie.getTheatreId(), movie.getMovieId());
}
	
	
	public List<Movie> getAllTheatresByMovie(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getMovieByName(String moviename) {
		
        System.out.println("Executing : " + QUERY_GET_MOVIE_BY_NAME);
        System.out.println("Executing : " + moviename);

        List<Movie> movie = jdbcTemplate.query(QUERY_GET_MOVIE_BY_NAME, new MovieMapper(),moviename);
        return movie ;
	}

	public List<Movie> getMovieBytheatreName(String theatrename) {
		System.out.println("Executing : " + QUERY_GET_MOVIE_BY_THEATRE_NAME );
        System.out.println("Executing : " +theatrename);

        List<Movie> movie = jdbcTemplate.query(QUERY_GET_MOVIE_BY_THEATRE_NAME , new MovieMapper(),theatrename);
        return movie ;
	}

}
