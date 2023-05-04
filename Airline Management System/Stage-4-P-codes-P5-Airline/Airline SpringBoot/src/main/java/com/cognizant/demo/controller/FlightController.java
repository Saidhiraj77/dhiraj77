package com.cognizant.demo.controller;

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

import com.cognizant.demo.entity.Flight;
import com.cognizant.demo.service.FlightService;

@RestController
@CrossOrigin({"*"})
public class FlightController {
	
	
	@Autowired
	private FlightService fs;
	
	@PostMapping("/flight")
	public int add(@RequestBody Flight flight) {
		return fs.create(flight);
	}
	@GetMapping("/flight")
	public List<Flight> getAllFlight() {
		return fs.read();
	}
	@GetMapping("/flight/{id}")
	public Flight findFlightById(@PathVariable Integer id) {
		return fs.read(id);
	}
	@PutMapping("/flight")
	public int modifyFlight(@RequestBody Flight flight) {
		return fs.update(flight);
	}
	@DeleteMapping("/flight/{id}")
	public int removeFlight(@PathVariable Integer id) {
		return fs.delete(id);
	}
	
	
}
