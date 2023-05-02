package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Book;

public interface MyBookingsDao {

	List<Book> getAllMyBookings(Long id);

	Book getBookingCount();

}