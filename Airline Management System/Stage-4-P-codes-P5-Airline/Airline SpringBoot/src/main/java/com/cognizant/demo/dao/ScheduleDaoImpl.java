package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.demo.entity.Schedule;
import com.cognizant.demo.helper.ScheduleRowMapper;

@Component
public class ScheduleDaoImpl implements ScheduleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Schedule schedule) {
		String sql = "INSERT INTO SCHEDULE VALUES(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, schedule.getId(), schedule.getFlight_id(), schedule.getSdate(),
				schedule.getStime(), schedule.getSource(), schedule.getDestination(), schedule.getDuration(),
				schedule.getAtime());
	}

	@Override
	public List<Schedule> read() {
		String sql = "SELECT * FROM SCHEDULE";
		return jdbcTemplate.query(sql, new ScheduleRowMapper());
	}

	@Override
	public Schedule read(Long id) {
		String sql = "SELECT * FROM SCHEDULE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new ScheduleRowMapper(), id);

	}

	@Override
	public int update(Schedule schedule) {
		String sql = "UPDATE SCHEDULE SET flight_id=?, sdate=?, stime=?,source=?, destination=?, duration=?, atime=? WHERE id=? ";
		return jdbcTemplate.update(sql, schedule.getFlight_id(), schedule.getSdate(), schedule.getStime(),
				schedule.getSource(), schedule.getDestination(), schedule.getDuration(), schedule.getAtime(),
				schedule.getId());

	}

	@Override
	public int delete(Long id) {
		String sql = "DELETE FROM SCHEDULE WHERE ID=?";
		return jdbcTemplate.update(sql, id);

	}

	public List<Schedule> getSourceDestination(String source, String destination) {
		String sql = "SELECT * FROM SCHEDULE WHERE SOURCE=? AND DESTINATION=?";
		return jdbcTemplate.query(sql, new ScheduleRowMapper(), source, destination);
	}
}
