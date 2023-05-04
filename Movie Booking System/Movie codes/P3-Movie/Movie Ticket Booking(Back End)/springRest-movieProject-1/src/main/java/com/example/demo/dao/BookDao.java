package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Book;

public interface BookDao {

	int create(Book book);

	List<Book> read();

	Book read(Long id);

	List<Book> findBooksByCustomer(Long customer_id);

	int update(Book book);

	int delete(Long id);

	Long generateBookId();

	Book getBookingId();

}