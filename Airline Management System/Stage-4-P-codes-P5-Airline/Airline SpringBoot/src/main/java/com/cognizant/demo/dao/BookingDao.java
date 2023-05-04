package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.Booking;

@Repository
public interface BookingDao {

	int create(Booking booking);

	List<Booking> read();

	Booking read(Long id);

	int update(Booking booking);

	int delete(Long id);
	
	List<Booking> getCurrentBooking(Long bookingid,Long userid);
	 
	List<Booking> getBookingDetailsByUserId(Long user_id);
	
	double Payment(String classtype, Long count);
}
