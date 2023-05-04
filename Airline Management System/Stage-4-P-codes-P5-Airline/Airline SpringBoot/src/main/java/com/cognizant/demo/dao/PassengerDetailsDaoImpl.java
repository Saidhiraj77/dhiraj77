
package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.demo.entity.PassengerDetails;
import com.cognizant.demo.helper.BookingRowMapper;
import com.cognizant.demo.helper.PassengerDetailsCountRowMapper;
import com.cognizant.demo.helper.PassengerDetailsRowMapper;

@Component
public class PassengerDetailsDaoImpl implements PassengerDetailsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(PassengerDetails passengerdetails) {
		return jdbcTemplate.update("INSERT INTO PASSENGERDETAILS VALUES (?,?,?,?,?,?,?)", passengerdetails.getId(),
				passengerdetails.getBooking_id(), passengerdetails.getSalutation(), passengerdetails.getFirstName(),
				passengerdetails.getLastName(), passengerdetails.getAge(), passengerdetails.getGender());
	}

	@Override
	public List<PassengerDetails> read() {
		return jdbcTemplate.query("SELECT * FROM PASSENGERDETAILS", new PassengerDetailsRowMapper());
	}

	@Override
	public PassengerDetails read(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM PASSENGERDETAILS WHERE id=?", new PassengerDetailsRowMapper(),
				id);
	}

	@Override
	public int update(PassengerDetails passengerdetails) {
		return jdbcTemplate.update(
				"UPDATE PASSENGERDETAILS SET booking_id=?, salutation=?, firstName=?, lastName=?, age=?, gender=? WHERE id=?",
				passengerdetails.getBooking_id(), passengerdetails.getSalutation(), passengerdetails.getFirstName(),
				passengerdetails.getLastName(), passengerdetails.getAge(), passengerdetails.getGender(),
				passengerdetails.getId());
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("DELETE FROM PASSENGERDETAILS WHERE id=?", id);
	}
	
	
	
	@Override
	public int deleteByBookingId(Long booking_id)
	{
		return jdbcTemplate.update("delete from passengerdetails where booking_id=?;", booking_id);
	}

	public int getCount(Long booking_id) {

		String sql = "select count(*) from (passengerdetails  pd) join (booking  b) on b.id=pd.booking_id where booking_id="
				+ booking_id;

		return jdbcTemplate.queryForObject(sql, Integer.class);

	}
}
