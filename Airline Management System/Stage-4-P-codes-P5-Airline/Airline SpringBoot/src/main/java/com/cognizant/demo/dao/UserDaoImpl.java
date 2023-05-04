package com.cognizant.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.demo.entity.Booking;
import com.cognizant.demo.entity.Userlogin;
import com.cognizant.demo.helper.UserRowMapping;


@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Userlogin user) {
		String sql = "insert into userdetails (id,username,password,email,pnumber,dob,gender,role) values(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getEmail(),
				user.getPnumber(),user.getDob(),user.getGender(), "user");
	}
	
	
	
	
	@Override
	public List<Userlogin> read() {
		String sql = "select * from userdetails";
		return jdbcTemplate.query(sql, new UserRowMapping());
	}

	@Override
	public Userlogin read(Long id) {
		return jdbcTemplate.queryForObject("select * from userdetails where id=?", new UserRowMapping(), id);
	}

	
	@Override
	public int modify(Userlogin user) {
		String sql = "update userdetails set password=?,email=?,pnumber=?,dob=?,gender=?,username=? where id=?";
		return jdbcTemplate.update(sql, user.getPassword(), user.getEmail(), user.getPnumber(),user.getDob(), user.getGender(),
				user.getUsername(), user.getId());
	}
	
	@Override
	public int delete(Long id) {
		String sql = "delete from userdetails where id=?";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public int editProfile(Userlogin user)
	{
		String sql="update userdetails set password=?,email=?,pnumber=?,gender=?,username=? where id=?";
		return jdbcTemplate.update(sql,user.getPassword(), user.getEmail(), user.getPnumber(), user.getGender(),
				user.getUsername(), user.getId());
	}
}