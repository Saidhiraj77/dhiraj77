package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.Flight;


@Repository
public interface FlightDaoInterface {

	int create(Flight flight);

	List<Flight> read();

	Flight read(Integer id);

	int update(Flight flight);

	int delete(Integer id);

}