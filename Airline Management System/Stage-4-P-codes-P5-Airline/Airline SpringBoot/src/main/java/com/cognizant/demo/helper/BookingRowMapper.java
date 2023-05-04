package com.cognizant.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cognizant.demo.entity.Booking;

@Component
public class BookingRowMapper implements RowMapper<Booking> {

	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Booking(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getInt(4),rs.getLong(5));

	}

}
