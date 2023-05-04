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
import com.cognizant.demo.service.BookingService;

@RestController
@CrossOrigin({ "http://localhost:4200", "*" })
public class BookingController {
  public Long id; 
	@Autowired
	private BookingService bs;

	@PostMapping("/booking")
	public int addBooking(@RequestBody Booking booking) {
		booking.setId(generateBookingId());
		id=booking.getId();
		return bs.create(booking);
	}

	@GetMapping("/booking")
	public List<Booking> getAllBookings() {
		return bs.read();
	}

	@GetMapping("/booking/{id}")
	public Booking findBookingById(@PathVariable Long id) {
		return bs.read(id);
	}

	@PutMapping("/booking")
	public int modifyBooking(@RequestBody Booking booking) {
		return bs.update(booking);
	}
	
	@GetMapping("/booking/bookingid")
	public Long returnBookingId()
	{
		return id;
	}
	
	@GetMapping("/booking/currentBooking/{bookingid}/{userid}")
	 public List<Booking> getCurrentBooking(@PathVariable Long bookingid, @PathVariable Long userid)
	 {
		return bs.getCurrentBooking(bookingid,userid);
	 }
	
	@DeleteMapping("/booking/{id}")
	public int removeBooking(@PathVariable Long id) {
		return bs.delete(id);
	}

	private Long generateBookingId() {
		List<Booking> bookings = getAllBookings();
		if (bookings.size() == 0)
			return 1L;
		Long lastIndex = bookings.get(bookings.size() - 1).getId();
		return lastIndex + 1;
	}
	
	@GetMapping("/booking/payment/{classtype}/{count}")
	 public double GetPayment(@PathVariable String classtype,@PathVariable Long count)
	 {
		return bs.payment(classtype,count);
	 }

	
	@GetMapping("/booking/mytrips/{user_id}")
	public List<Booking> getBookingDetailsByUserId(@PathVariable Long user_id)
	{
		return bs.bookingDetailsByUserId(user_id);
	}

}
