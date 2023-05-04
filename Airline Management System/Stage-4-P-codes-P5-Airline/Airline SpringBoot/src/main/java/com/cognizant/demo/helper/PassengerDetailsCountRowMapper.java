package com.cognizant.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PassengerDetailsCountRowMapper implements RowMapper<Integer>
{

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getInt(1);
	}

	

}
