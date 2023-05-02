package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MyBookingsDao;
import com.example.demo.model.Book;

@Service
public class MyBookingsService {

	@Autowired
	private MyBookingsDao mbdao;
	
	public List<Book> getAllMyBookings(Long id) {
		// TODO Auto-generated method stub
		return mbdao.getAllMyBookings(id);
	}

	public Book getBookingCount() {
		// TODO Auto-generated method stub
		return mbdao.getBookingCount();
	}

}
