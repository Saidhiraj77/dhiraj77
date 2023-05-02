package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bdao;
	
	public int create(Book book)
	{
		return bdao.create(book);
	}

	public List<Book> read()
	{
		return bdao.read();
	}

	public Book read(Long id)
	{
		return bdao.read(id);
	}

	public int update(Book book)
	{
		return bdao.update(book);
	}

	public int delete(Long id)
	{
		return bdao.delete(id);
	}
	
	public List<Book> findBooksByCustomer(Long customer_id)
	{
		return bdao.findBooksByCustomer(customer_id);
	}

	public Long generateBookId() {
		// TODO Auto-generated method stub
		return bdao.generateBookId();
	}

	public Book getBookingId() {
		// TODO Auto-generated method stub
		return  bdao.getBookingId();
	}
}
