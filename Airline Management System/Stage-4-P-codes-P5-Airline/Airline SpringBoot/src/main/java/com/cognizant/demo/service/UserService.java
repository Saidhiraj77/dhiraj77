package com.cognizant.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.demo.dao.UserDao;
import com.cognizant.demo.entity.Userlogin;
import com.cognizant.demo.exceptions.RecordAlreadyPresentException;


@Service
public class UserService {

	@Autowired
	private UserDao ud;

	public int create(Userlogin user) {
		return ud.create(user);
	}
	

	public List<Userlogin> read() {
		return ud.read();
	}

	public Userlogin read(Long id) {
		return ud.read(id);
	}

	public int modify(Userlogin user) {
		return ud.modify(user);
	}

	public int delete(Long id) {
		return ud.delete(id);
	}
	
	public int editProfile(Userlogin user) {
		return ud.editProfile(user);
	}
	
}
