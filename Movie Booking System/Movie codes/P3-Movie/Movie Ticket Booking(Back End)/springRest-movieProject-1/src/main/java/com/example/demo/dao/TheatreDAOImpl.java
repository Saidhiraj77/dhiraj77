package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.mappers.MovieMapper;
import com.example.demo.mappers.TheatreMapper;
import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;

@Component
public class TheatreDAOImpl implements TheatreDAO {

	  private JdbcTemplate jdbcTemplate;

	    @Autowired(required=true)
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    

		@Override
		public List<Theatre> getAllTheatres() {
			 System.out.println("Executing : " + QUERY_GET_ALL_THEATRES);
		        
		        List<Theatre> theatres=
		                this.jdbcTemplate.query(QUERY_GET_ALL_THEATRES,
		                new TheatreMapper());
		        
		        return theatres;
		}

		@Override
		public Theatre findTheatreByID(Long id) {
			System.out.println("Executing : " + QUERY_ADD_NEW_THEATRE);
	        
	        Theatre theatre=new Theatre();
	        try{
	            theatre=
	                    this.jdbcTemplate.queryForObject(QUERY_FIND_THEATRE_BY_ID,
	                    new TheatreMapper(),id);
	            
	        }catch(DataAccessException de){
	            System.err.println(de.getMessage());
	        }
	        return theatre;
		}
		
		public List<Movie> getAllMovieByTheatre(Long id){
          System.out.println("Executing : " + QUERY_GET_ALL_MOVIES_IN_THEATRE);
	        
          List<Movie> theatres = null;
	        try{
	            theatres=
	                    this.jdbcTemplate.query(QUERY_GET_ALL_MOVIES_IN_THEATRE,
	                    new MovieMapper(),id);
	            
	        }catch(DataAccessException de){
	            System.err.println(de.getMessage());
	        }
	        return theatres;
			
		}

		@Override
		public boolean createNewTheatre(Theatre theatre) {
			  System.out.println("Executing : " + QUERY_ADD_NEW_THEATRE);
		        
		        int affectedrows=
		                this.jdbcTemplate.update(QUERY_ADD_NEW_THEATRE,
		                theatre.getTheatreId() ,theatre.getTheatreName());
		        
		        return (affectedrows == 1);
		}


		public int update(Theatre theatre) {
			System.out.println("Executing : " + QUERY_MODIFY_THEATRE_BY_ID);
			return jdbcTemplate.update(QUERY_MODIFY_THEATRE_BY_ID, theatre.getTheatreName(), theatre.getTheatreId());
		}


		public int delete(Long id) {
			System.out.println("Executing : " + QUERY_DELETE_THEATRE_BY_ID);
	        
	            return jdbcTemplate.update(QUERY_DELETE_THEATRE_BY_ID, id);
	 
		}

	
}
