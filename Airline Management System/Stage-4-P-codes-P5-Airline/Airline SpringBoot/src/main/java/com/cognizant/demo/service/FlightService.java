package com.cognizant.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.dao.FlightDao;
import com.cognizant.demo.entity.Flight;

@Service
public class FlightService {
	
	@Autowired
	private FlightDao fdao;
	public int create(Flight flight) {
		return fdao.create(flight);
	}
	public List<Flight> read(){
		return fdao.read();
	}
	public Flight read(Integer id){
		return fdao.read(id);
	}
	 public int update(Flight flight) {
		return fdao.update(flight);
	}
	public int delete(Integer id) {
		return fdao.delete(id);
	}

}
