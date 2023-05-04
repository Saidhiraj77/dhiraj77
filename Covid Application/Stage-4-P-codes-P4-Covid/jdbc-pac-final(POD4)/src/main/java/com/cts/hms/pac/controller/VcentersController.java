package com.cts.hms.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hms.pac.entity.Vcenters;
import com.cts.hms.pac.service.VcentersService;


@RestController
@CrossOrigin({"http://localhost:4200","*"})
public class VcentersController {
	@Autowired
	private VcentersService vs;
	
	@PostMapping("/centers")
	public int signup(@RequestBody Vcenters vcenters)
	{
		System.out.println("adding vcenter");
		return vs.create(vcenters);
	}
	
	@GetMapping("/centers")
	public List<Vcenters> getAllVcenterss()
	{
		return vs.read();
	}
	
	@GetMapping("/centers/id/{id}")
	public Vcenters findVcentersById(@PathVariable Long id)
	{
		return vs.read(id);
	}
	
	@GetMapping(value="/centers/{pinCode}")
	public List<Vcenters> findVcentersByPincode(@PathVariable Long pinCode)
	{
		return vs.readbyPincode(pinCode);
	}
	
	@PutMapping("/centers")
	public int modifyVcenters(@RequestBody Vcenters Vcenters)
	{
		return vs.update(Vcenters);
	}
	
	@DeleteMapping("/centers/{id}")
	public int removeVcenters(@PathVariable Long id)
	{
		return vs.delete(id);
	}
}

