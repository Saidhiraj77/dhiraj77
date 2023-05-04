package com.cognizant.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.demo.entity.Flight;



public class FlightRowMapper implements RowMapper<Flight> {
	
	@Override
	public Flight mapRow(ResultSet rs,int rowNum) throws SQLException {
		return new Flight(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
	}
}
	
	//@Override
	//public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		//return new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getFloat(4));


