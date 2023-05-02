package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.example.demo.model.Book;

@Component
public class BookRowMapper implements RowMapper<Book>
{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Book book=null;
			try {
				book=new Book(rs.getLong(1), sdf.parse(rs.getString(2)), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getLong(6), rs.getString(7));
			} catch (ParseException e) {
				book=null;
			}
		return book;
	}

}
