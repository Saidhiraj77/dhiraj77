package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.MyBookingsService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"}, allowedHeaders = "*")
public class MyBookingsController {
	
	
	@Autowired
	private MyBookingsService mbs;
	
	@GetMapping("/mybookings/{id}")
	public List<Book> getAllMyBookings(@PathVariable("id") Long id ){
		
		return mbs.getAllMyBookings(id);
	}
	
	@GetMapping("/mybookings")
	public Book getBookingCount(){
		return mbs.getBookingCount();
	}
	
}
