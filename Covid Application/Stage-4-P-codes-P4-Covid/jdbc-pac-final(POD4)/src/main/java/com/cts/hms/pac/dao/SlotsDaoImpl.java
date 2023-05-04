package com.cts.hms.pac.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.hms.pac.entity.Slots;

@Component
public class SlotsDaoImpl implements SlotsDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public int create(Slots slots) {
		return jdbcTemplate.update("INSERT INTO SLOTS VALUES (?,?,?,?,?,?,?)", slots.getId(), slots.getSlotDate(), slots.getSlotTime(), slots.getUserName(), slots.getCenterName(), slots.getVType(),slots.getAadharNumber());
	}
	
	
	@Override
	public List<Slots> read() {
		return jdbcTemplate.query("SELECT * FROM SLOTS", new SlotsRowMapper());
	}
	
	
	@Override
	public Slots read(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM SLOTS WHERE id=?", new SlotsRowMapper(), id);
	}
	
	@Override
	public Slots readbyUsername(String userName) {
		return jdbcTemplate.queryForObject("SELECT * FROM SLOTS WHERE userName=?", new SlotsRowMapper(),userName);
	}
	
	
	@Override
	public int update(Slots slots) {
		return jdbcTemplate.update("UPDATE SLOTS SET slotDate, slotTime=?, userName, centerName, vType=? WHERE id=?", slots.getSlotDate(), slots.getSlotTime(), slots.getUserName(), slots.getCenterName(), slots.getVType(), slots.getId());
	}
	
	
	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("DELETE FROM SLOTS WHERE id=?",id);
	}
	

}
