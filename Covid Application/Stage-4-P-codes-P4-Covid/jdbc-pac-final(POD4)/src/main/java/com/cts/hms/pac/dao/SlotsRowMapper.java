package com.cts.hms.pac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cts.hms.pac.entity.Slots;

@Component
public class SlotsRowMapper implements RowMapper<Slots> {

	@Override
	public Slots mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Slots slots=null;
			try {
				slots= new Slots(rs.getLong("id"), sdf.parse(rs.getString("slotDate")), rs.getString("slotTime"), rs.getString("userName"), rs.getString("centerName"),rs.getString("vType"),rs.getLong("aadharNumber"));
			} catch (ParseException e) {
				slots=null;
			}
		return slots;
	}
}