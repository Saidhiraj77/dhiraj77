package com.cognizant.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.Userlogin;
import com.cognizant.demo.exceptions.RecordAlreadyPresentException;
import com.cognizant.demo.service.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "*" }, allowedHeaders = "*")
public class UserController {

	@Autowired
	public UserService us;

	@GetMapping("/user")
	public List<Userlogin> getDetails() {
		return us.read();
	}

	@GetMapping("/user/{id}")
	public Userlogin getAllDetails(@PathVariable Long id) {
		return us.read(id);
	}
	
	@GetMapping("/user/{id}/{password}")
	public Userlogin login(@PathVariable Long id, @PathVariable String password) {
		Userlogin user = us.read(id);
		if (user.getId() == id && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@PostMapping("/user")
	public int create(@RequestBody Userlogin user) {
		return us.create(user);
	}
	

	@PutMapping("/user")
	public int modifyUser(@RequestBody Userlogin user) {
		return us.modify(user);

	}
	
	
	@PutMapping("/user/password")
	public int changePassword(@RequestBody Userlogin user) {
		System.out.println(user.toString());
		return us.editProfile(user);
	}
	


	@DeleteMapping("/user/{id}")
	public int deleteUser(@PathVariable Long id) {
		return us.delete(id);
	}
}
