package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.demo.entity.Booking;
import com.cognizant.demo.helper.BookingRowMapper;

@Component
public class BookingDaoImpl implements BookingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Booking booking) {
		return jdbcTemplate.update("INSERT INTO BOOKING VALUES (?,?,?,?,?)", booking.getId(), booking.getSchedule_id(),
				booking.getClasstype(), booking.getPassengers(), booking.getUser_id());
	}

	@Override
	public List<Booking> read() {
		return jdbcTemplate.query("SELECT * FROM BOOKING", new BookingRowMapper());
	}

	@Override
	public Booking read(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM BOOKING WHERE id=?", new BookingRowMapper(), id);
	}
	
	@Override
	public List<Booking> getCurrentBooking(Long bookingid,Long userid) {
		return jdbcTemplate.query("select * from booking where user_id=? and id=?;", new BookingRowMapper(),userid, bookingid);
	}

	@Override
	public int update(Booking booking) {
		return jdbcTemplate.update("UPDATE BOOKING SET schedule_id=?, classtype=?,passengers=?, user_id=? WHERE id=?",
				booking.getSchedule_id(), booking.getClasstype(), booking.getPassengers(), booking.getUser_id(),
				booking.getId());
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("DELETE FROM BOOKING WHERE id=?", id);
	}
	
	@Override
	public List<Booking> getBookingDetailsByUserId(Long user_id)
	{
		return jdbcTemplate.query("select * from booking where user_id=?", new BookingRowMapper(), user_id);
	}
	
	
	@Override
	public double Payment(String classtype, Long count) {
		double cost = 0;
		if (classtype.equals("First Class")) {
			cost = 20000;
		} else if (classtype.equals("Business")) {
			cost = 15000;
		} else {
			cost = 10000;
		}

		return cost * count;
	}
}
