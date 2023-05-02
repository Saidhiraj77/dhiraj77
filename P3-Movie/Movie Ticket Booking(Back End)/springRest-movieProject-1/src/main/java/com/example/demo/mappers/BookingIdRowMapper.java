package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Book;

public class BookingIdRowMapper implements RowMapper<Book> {


	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Book(rs.getLong(1));
	}
}
