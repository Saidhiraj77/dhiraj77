package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.Userlogin;


@Repository
public interface UserDao {
		
	public int create(Userlogin user);
	
	public List<Userlogin> read();
	
	public Userlogin read(Long id);
	
	public int modify(Userlogin user);	
	
	public int delete(Long id);
	
	public int editProfile(Userlogin user);
}
