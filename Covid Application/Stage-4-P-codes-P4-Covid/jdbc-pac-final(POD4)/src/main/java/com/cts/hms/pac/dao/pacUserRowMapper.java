package com.cts.hms.pac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.hms.pac.entity.pacUser;

public class pacUserRowMapper implements RowMapper<pacUser>{

	@Override
	public pacUser mapRow(ResultSet rs, int rowNum) throws SQLException {

    return new pacUser(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("userName"), rs.getString("email"), rs.getString("gender"), rs.getLong("age"), rs.getString("password"));

	}
}
