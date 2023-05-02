package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.MyUser;

public class UsersCountRowMapper  implements RowMapper<MyUser> {
	@Override
	public MyUser mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new MyUser(rs.getLong(1));
	}
}