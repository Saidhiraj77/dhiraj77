package com.cognizant.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cognizant.demo.entity.PassengerDetails;

@Repository
public interface PassengerDetailsDao {

	int create(PassengerDetails passengerdetails);

	List<PassengerDetails> read();

	PassengerDetails read(Long id);

	int update(PassengerDetails passengerdsetails);

	int delete(Long id);

	int getCount(Long booking_id);

	int deleteByBookingId(Long booking_id);
}
