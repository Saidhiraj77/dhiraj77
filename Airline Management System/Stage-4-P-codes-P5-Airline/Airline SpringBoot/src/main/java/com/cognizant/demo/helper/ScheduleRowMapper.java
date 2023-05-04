package com.cognizant.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.demo.entity.Schedule;

public class ScheduleRowMapper implements RowMapper<Schedule> {

	@Override
	public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		String str = rs.getString(4);
		String str1=rs.getString(8);
		LocalTime lt1=LocalTime.parse(str1);
		LocalTime lt = LocalTime.parse(str);
		try {
			return new Schedule(rs.getLong(1), rs.getLong(2), sdf.parse(rs.getString(3)), lt, rs.getString(5),
					rs.getString(6), rs.getInt(7),lt1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
