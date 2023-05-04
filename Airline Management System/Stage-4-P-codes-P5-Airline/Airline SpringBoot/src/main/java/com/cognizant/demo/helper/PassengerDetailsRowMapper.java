package com.cognizant.demo.helper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.demo.entity.PassengerDetails;



public class PassengerDetailsRowMapper implements RowMapper<PassengerDetails>
{

	@Override
	public PassengerDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new PassengerDetails(rs.getLong(1), rs.getLong(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
	}

}


