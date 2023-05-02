package com.example.demo.controller;
import java.util.Collections;
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

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@CrossOrigin({"http://localhost:4200","*"})
public class BookingController {
	
	@Autowired
	private BookService cs;
	
	@PostMapping("/book")
	public int addBook(@RequestBody Book book)
	{ 
	   System.out.println("add book "+ book);	
		book.setId(generateBookId());
		return cs.create(book);
	}
	
	@GetMapping("/book")
	public List<Book> getAllBooks()
	{
		return cs.read();
	}
	
	@GetMapping("/book/booking/bid")
	public Book getbookingId() {
		return cs.getBookingId();
	}
	
	@GetMapping("/book/{id}")
	public Book findBookById(@PathVariable Long id)
	{
		return cs.read(id);
	}
	
	@GetMapping("/book/customer/{id}")
	public List<Book> findBooksByCustomer(@PathVariable Long id)
	{
		return cs.findBooksByCustomer(id);
	}
	
		private Long generateBookId()
		{
			List<Book> book = getAllBooks();
			if(book.size()==0)
			{
				return 1L;
			}
			Long lastIndex=book.get(book.size()-1).getId();
			return lastIndex+1;
		}
	
	@PutMapping("/book")
	public int modifyBook(@RequestBody Book book)
	{
		return cs.update(book);
	}
	
	@DeleteMapping("/book/{id}")
	public int removeBook(@PathVariable Long id)
	{
		return cs.delete(id);
	}
}
