package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.mappers.BookRowMapper;
import com.example.demo.mappers.BookingIdRowMapper;
import com.example.demo.model.Book;

@Component
public class MyBookingsDaoImpl implements MyBookingsDao {

	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
   
	@Override
	public List<Book> getAllMyBookings(Long id) {

		return jdbcTemplate.query("SELECT * FROM booking WHERE customer_id=?;", new BookRowMapper(),id);
	}

	@Override
	public Book getBookingCount() {

		return jdbcTemplate.queryForObject("select count(id) from booking;", new BookingIdRowMapper());
	}

}
