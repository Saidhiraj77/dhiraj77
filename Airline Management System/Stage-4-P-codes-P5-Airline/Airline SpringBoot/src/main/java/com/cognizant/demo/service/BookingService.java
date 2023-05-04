package com.cognizant.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.dao.BookingDao;
import com.cognizant.demo.entity.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao bdao;

	public int create(Booking booking) {
		return bdao.create(booking);
	}

	public List<Booking> read() {
		return bdao.read();
	}

	public Booking read(Long id) {
		return bdao.read(id);
	}

	public int update(Booking booking) {
		return bdao.update(booking);
	}

	public int delete(Long id) {
		return bdao.delete(id);
	}

	public double payment(String classtype, Long count) {

		return bdao.Payment(classtype, count);
	}
	
	public List<Booking> bookingDetailsByUserId(Long user_id)
	{
		return bdao.getBookingDetailsByUserId(user_id);
	}
	
	 public List<Booking> getCurrentBooking(Long bookingid,long userid)
	 {
		 return bdao.getCurrentBooking(bookingid,userid);
	 }


}
