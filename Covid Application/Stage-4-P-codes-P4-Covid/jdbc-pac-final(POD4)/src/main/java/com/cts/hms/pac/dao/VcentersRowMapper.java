package com.cts.hms.pac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.hms.pac.entity.Vcenters;

public class VcentersRowMapper implements RowMapper<Vcenters> {

	@Override
	public Vcenters mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Vcenters(rs.getLong("id"), rs.getString("name"), rs.getLong("pinCode"));
	}
}
