package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.mappers.MyUserRowMapper;
import com.example.demo.mappers.UsersCountRowMapper;
import com.example.demo.model.MyUser;


@Service
public class MyUserDetailsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(MyUser user) {
		String sql="INSERT INTO MyUser VALUES(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, user.getUserId(), user.getUsername(),user.getPassword(), "user", user.getEmail(), user.getPhone(), user.getGender());
	}
	public List<MyUser> read() {
		return jdbcTemplate.query("SELECT * FROM MyUser", new MyUserRowMapper());
	}
	public MyUser read(String username) {
		return jdbcTemplate.queryForObject("SELECT * FROM MyUser WHERE username=?", new MyUserRowMapper(), username);
	}
	public int update(MyUser user) {
		String sql="UPDATE MyUser SET username=?, email=?, phone=?, gender=?,  password=? WHERE userId=?";
		return jdbcTemplate.update(sql, user.getUsername(),user.getEmail(), user.getPhone(), user.getGender(), user.getPassword(), user.getUserId());
	}
	public int delete(Long userId) {
		String sql="DELETE FROM MyUser WHERE userId=?";
		return jdbcTemplate.update(sql, userId);
	}
//	public int modifyUser(MyUser user) {
//		String sql="UPDATE MyUser SET  username=?, email=?, phone=?, gender=?, password=?, role=? WHERE userId=? ";
//		return jdbcTemplate.update(sql,user.getUsername(), user.getEmail(), user.getPhone(), user.getGender(), user.getPassword(), user.getRole(), user.getUserId());
//	}
	public int modifyUser(MyUser user) {
		String sql="UPDATE MyUser SET  username=?, email=?, phone=?, gender=? WHERE userId=? ";
		return jdbcTemplate.update(sql,user.getUsername(), user.getEmail(), user.getPhone(), user.getGender(), user.getUserId());
	}
	public int modifyUserbyUserName(MyUser user) {
		String sql="UPDATE MyUser SET  username=?, email=?, phone=?, gender=? WHERE username=? ";
		return jdbcTemplate.update(sql,user.getUsername(), user.getEmail(), user.getPhone(), user.getGender(), user.getUserId());
	}
	public int deleteUser(String username) {
		String sql="DELETE FROM MyUser WHERE username=?";
		return jdbcTemplate.update(sql, username);
   
	}
	public MyUser getUserById(Long id) {
		String sql = "SELECT * FROM MyUser where userId= ?";
		return jdbcTemplate.queryForObject(sql, new MyUserRowMapper(),id);
	}
	public MyUser getUsersCount() {
		String sql = "SELECT count(userId) FROM MyUser ";
		return jdbcTemplate.queryForObject(sql, new UsersCountRowMapper());

	}

}
