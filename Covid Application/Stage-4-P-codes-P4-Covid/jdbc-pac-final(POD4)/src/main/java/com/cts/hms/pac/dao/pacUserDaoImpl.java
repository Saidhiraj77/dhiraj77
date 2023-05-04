package com.cts.hms.pac.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.hms.pac.entity.pacUser;

@Component
public class pacUserDaoImpl implements pacUserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(pacUser pacuser) {
		return jdbcTemplate.update("INSERT INTO PACUSER VALUES (?,?,?,?,?,?,?,?)", pacuser.getId(), pacuser.getFirstName(), pacuser.getLastName(), pacuser.getUserName(),pacuser.getEmail(),pacuser.getGender(),pacuser.getAge(),pacuser.getPassword());
	}
	@Override
	public List<pacUser> read() {
		return jdbcTemplate.query("SELECT * FROM PACUSER", new pacUserRowMapper());
	}
	@Override
	public pacUser read(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM PACUSER WHERE id=?", new pacUserRowMapper(), id);
	}
	@Override
	public pacUser read(String userName) {
		return jdbcTemplate.queryForObject("SELECT * FROM PACUSER WHERE userName=?", new pacUserRowMapper(), userName);
	}
	@Override
	public pacUser fetchUserByUserNameAndPassword(String tempUserId, String tempPass) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM PACUSER WHERE userName=? AND password=?", new pacUserRowMapper(), tempUserId,tempPass);
	}
	@Override
	public int update(pacUser pacuser) {
		return jdbcTemplate.update("UPDATE PACUSER SET firstName=?, lastName=?, userName=?, email=?, gender=?, age=? WHERE id=?", pacuser.getFirstName(), pacuser.getLastName(), pacuser.getUserName(), pacuser.getEmail(), pacuser.getGender(), pacuser.getAge(), pacuser.getId());
	}
	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("DELETE FROM PACUSER WHERE id=?",id);
	}
	

}
