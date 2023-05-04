package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.demo.entity.Flight;
import com.cognizant.demo.helper.FlightRowMapper;

@Component
public class FlightDao implements FlightDaoInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Flight flight) {

		return jdbcTemplate.update("INSERT INTO FLIGHT VALUES(?,?,?,?,?,?,?,?)", flight.getId(),
				flight.getFlightNumber(), flight.getFlightName(), flight.getModel(), flight.getType(),
				flight.getEconomySeats(), flight.getBusinessSeats(), flight.getFirstClassSeats());
	}

	@Override
	public List<Flight> read() {
		return jdbcTemplate.query("SELECT * FROM FLIGHT", new FlightRowMapper());
	}

	@Override
	public Flight read(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM FLIGHT WHERE id=?", new FlightRowMapper(), id);

	}

	@Override
	public int update(Flight flight) {

		return jdbcTemplate.update(
				"update flight set flightNumber=?, flightName=?, model=?, type=?, economySeats=?, businessSeats=? , firstClassSeats=? WHERE id=?",
				flight.getFlightNumber(), flight.getFlightName(),  flight.getModel(),flight.getType(),
				flight.getEconomySeats(), flight.getBusinessSeats(), flight.getFirstClassSeats(), flight.getId());
	}

	@Override
	public int delete(Integer id) {

		return jdbcTemplate.update("DELETE FROM FLIGHT WHERE id=?", id);
	}

}
