package com.example.demo.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.mappers.BookRowMapper;
import com.example.demo.mappers.BookingIdRowMapper;
import com.example.demo.mappers.MyBookRowMapper;
import com.example.demo.model.Book;

@Component
public class BookDaoImpl implements BookDao  {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public int create(Book book) {
		System.out.println("Insert Book Details: "+ book);
		return jdbcTemplate.update("INSERT INTO booking VALUES (?,?,?,?,?,?,?)", book.getId(), book.getBookDate(), book.getTheatreId(), book.getMovieId(),book.getCustomerId(), book.getTickets(), book.getSeatType());
	}
	
	public Long generateBookId() {
		 
		List<Book> n = jdbcTemplate.query("SELECT * FROM booking b where b.id IN ( select max(id) from  booking ) order by id desc", new BookRowMapper());;
		Book lastbook = n.get(0);
		Long max  = lastbook.getId();
		Long genId=1L;
		if(max==0L) {
			genId=1L;
		}else {
			genId=max + 1L;
		}
		
		return genId;
	}
	
	
	@Override
	public List<Book> read() {
		return jdbcTemplate.query("SELECT * FROM booking ", new BookRowMapper());
	}
	
	
	@Override
	public Book read(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM booking WHERE id=?", new BookRowMapper(), id);
	}
	
	
	@Override
	public List<Book> findBooksByCustomer(Long customer_id)
	{
		return jdbcTemplate.query("SELECT  b.id,b.bookingDate, b.theatre_id, b.movie_id, b.customer_id, b.tickets, b.seatType, m.movieName,t.theatreName\r\n"
				+ "FROM ((booking b\r\n"
				+ "INNER JOIN movie m ON b.movie_id = m.movieId)\r\n"
				+ "INNER JOIN theatre t ON b.theatre_id = t.theatreId) where b.customer_id = ?;", new MyBookRowMapper(), customer_id);
	}
	
	
	@Override
	public int update(Book book) {
		return jdbcTemplate.update("UPDATE booking SET bookingDate=?, theatre_id=?, movie_id=?, customer_id, tickets WHERE id=?", book.getBookDate(), book.getTheatreId(), book.getMovieId(),book.getCustomerId(), book.getTickets(), book.getId());
	}
	
	
	
	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("DELETE FROM booking WHERE id=?",id);
	}

	@Override
	public Book getBookingId() {
		return jdbcTemplate.queryForObject("SELECT MAX(id) FROM booking ", new BookingIdRowMapper());
	}
	
}
