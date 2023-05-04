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

import com.cognizant.demo.entity.Booking;
import com.cognizant.demo.entity.PassengerDetails;
import com.cognizant.demo.service.BookingService;
import com.cognizant.demo.service.PassengerDetailsService;

@RestController
@CrossOrigin({ "http://localhost:4200", "*" })
public class PassengerController {

	@Autowired
	private PassengerDetailsService ps;
	@Autowired
	private BookingService bs;

	@PostMapping("/passengerdetails")
	public int signup(@RequestBody PassengerDetails passengerdetails) {
		passengerdetails.setId(generateBookingId());
		return ps.create(passengerdetails);
	}

	@GetMapping("/passengerdetails")
	public List<PassengerDetails> getAllPassengerDetails() {
		return ps.read();
	}

	@GetMapping("/passengerdetails/{id}")
	public PassengerDetails findPassengerDetailsById(@PathVariable Long id) {
		return ps.read(id);
	}

	@PutMapping("/passengerdetails")
	public int modifyPassengerDetails(@RequestBody PassengerDetails passengerdetails) {
		return ps.update(passengerdetails);
	}

	@DeleteMapping("/passengerdetails/{id}")
	public int removePassengerDetails(@PathVariable Long id) {
		return ps.delete(id);
	}

	@GetMapping("/passengerdetails/count/{booking_id}")
	public int getPassengerCount(@PathVariable Long booking_id) {
		return ps.getCount(booking_id);
	}

	@DeleteMapping("/passengerdetails/bookingid/{booking_id}")
	public int deletePassengerByBookingId(@PathVariable Long booking_id)
	{
		return ps.deleteByBookingId(booking_id);
	}
	
	
	private Long generateBookingId() {
		List<PassengerDetails> bookings = getAllPassengerDetails();
		if (bookings.size() == 0)
			return 1L;
		Long lastIndex = bookings.get(bookings.size() - 1).getId();
		return lastIndex + 1;
	}
}
