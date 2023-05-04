
package com.cognizant.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.dao.PassengerDetailsDao;
import com.cognizant.demo.entity.PassengerDetails;

@Service
public class PassengerDetailsService {
	@Autowired
	private PassengerDetailsDao pdao;

	public int create(PassengerDetails passengerdetails) {
		return pdao.create(passengerdetails);
	}

	public List<PassengerDetails> read() {
		return pdao.read();
	}

	public PassengerDetails read(Long id) {
		return pdao.read(id);
	}

	public int update(PassengerDetails passengerdetails) {
		return pdao.update(passengerdetails);
	}

	public int delete(Long id) {
		return pdao.delete(id);
	}

	public int getCount(Long booking_id) {
		return pdao.getCount(booking_id);
	}

	public int deleteByBookingId(Long booking_id) {
		return pdao.deleteByBookingId(booking_id);
	}

}
