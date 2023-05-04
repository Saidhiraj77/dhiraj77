package com.cts.hms.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hms.pac.entity.pacUser;
import com.cts.hms.pac.service.pacUserService;



@RestController
@CrossOrigin({"http://localhost:4200","*"})
public class pacUserController {
	
	@Autowired
	private pacUserService ps;
	
	@GetMapping("/")
	public String home()
	{
		return "Progressive Application for COVID-19";
	}
	
	@GetMapping("/user")
	public List<pacUser> getAllpacUsers()
	{
		return ps.read();
	}
	
//	@GetMapping("/user/{id}")
//	public pacUser findpacUserById(@PathVariable Long id)
//	{
//		pacUser pacuser=null;
//		try
//		{
//			pacuser=ps.read(id);
//		}catch(EmptyResultDataAccessException erde)
//		{
//			pacuser=new pacUser();
//		}
//		return pacuser;
//	}
	@GetMapping("/user/{userName}")
	public pacUser findpacUserById(@PathVariable String userName)
	{
		pacUser pacuser=null;
		try
		{
			pacuser=ps.read(userName);
		}catch(EmptyResultDataAccessException erde)
		{
			pacuser=new pacUser();
		}
		return pacuser;
	}
	
	@PostMapping("/user")
	public int addpacUser(@RequestBody pacUser pacuser)
	{
		System.out.print("add user");
		return ps.create(pacuser);
	}
	
	@PostMapping("/login") 
	public pacUser loginUser(@RequestBody pacUser pacuser) throws Exception{
		String tempUserId=pacuser.getUserName();
		String tempPass=pacuser.getPassword();
		pacUser pacuserObj=null;
		if(tempUserId !=null && tempPass!=null)
		{
			pacuserObj=ps.fetchUserByUserNameAndPassword(tempUserId , tempPass);
		}
		if(pacuserObj==null) {
			throw new Exception("bad");
		}
		return pacuserObj;
	}
	
	@PutMapping("/user")
	public int modifypacUser(@RequestBody pacUser pacuser)
	{
		return ps.update(pacuser);
	}
	
	@DeleteMapping("/user/{id}")
	public int removepacUser(@PathVariable Long id)
	{
		return ps.delete(id);
	}


}
