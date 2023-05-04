package com.cts.hms.pac.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.hms.pac.entity.Vcenters;

@Component
public class VcentersDaoImpl implements VcentersDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int create(Vcenters vcenters) {
		return jdbcTemplate.update("INSERT INTO VCENTERS VALUES (?,?,?)", vcenters.getId(), vcenters.getName(), vcenters.getPinCode());
	}
	
	@Override
	public List<Vcenters> read() {
		return jdbcTemplate.query("SELECT * FROM VCENTERS", new VcentersRowMapper());
	}
	
	@Override
	public Vcenters read(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM VCENTERS WHERE id=?", new VcentersRowMapper(), id);
	}
	
	@Override
	public List<Vcenters> readbyPincode(Long pinCode) {
		return jdbcTemplate.query("SELECT * FROM VCENTERS WHERE pinCode=?", new VcentersRowMapper(), pinCode);
	}
	
	
	@Override
	public int update(Vcenters vcenters) {
		return jdbcTemplate.update("UPDATE VCENTERS SET name=?, pinCode=? WHERE id=?", vcenters.getName(), vcenters.getPinCode(), vcenters.getId());
	}
	
	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("DELETE FROM VCENTERS WHERE id=?",id);
	}
	
	
}


