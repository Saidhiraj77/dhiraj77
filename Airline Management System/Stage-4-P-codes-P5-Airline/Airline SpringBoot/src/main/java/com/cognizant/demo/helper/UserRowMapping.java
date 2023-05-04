package com.cognizant.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.demo.entity.Userlogin;

public class UserRowMapping implements RowMapper<Userlogin> {

	@Override
	public Userlogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return new Userlogin(rs.getLong("id"), rs.getString("username"), rs.getString("password"),
					rs.getString("email"), rs.getLong("pnumber"), sdf.parse(rs.getString("dob")), rs.getString("gender"), rs.getString("role"));
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
