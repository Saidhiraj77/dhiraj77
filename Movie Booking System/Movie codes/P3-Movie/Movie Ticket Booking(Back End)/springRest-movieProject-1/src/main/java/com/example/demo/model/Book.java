package com.example.demo.model;
import java.util.Date;

public class Book {
	private Long id;
	private Date bookDate;
	private Long theatreId;
	private Long movieId;
	private Long customerId;
	private Long tickets;
	private String seatType;
	private String theatreName;
	private String movieName;
	
	public Book()
	{
		
	}
	public Book(Long id)
	{
		super();
		this.id= id;
		
	}

	
	public Book(Long id, Date bookDate, Long theatreId, Long movieId, Long customerId, Long tickets, String seatType) {
		super();
		this.id = id;
		this.bookDate = bookDate;
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.customerId = customerId;
		this.tickets = tickets;
		this.seatType = seatType;
	}

	
	public Book(Long id, Date bookDate, Long theatreId, Long movieId, Long customerId, Long tickets, String seatType,
			 String movieName,String theatreName) {
		super();
		this.id = id;
		this.bookDate = bookDate;
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.customerId = customerId;
		this.tickets = tickets;
		this.seatType = seatType;
		this.movieName = movieName;
		this.theatreName = theatreName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getTickets() {
		return tickets;
	}

	public void setTickets(Long tickets) {
		this.tickets = tickets;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookDate=" + bookDate + ", theatreId=" + theatreId + ", movieId=" + movieId
				+ ", customerId=" + customerId + ", tickets=" + tickets + ", seatType=" + seatType + ", theatreName="
				+ theatreName + ", movieName=" + movieName + "]";
	}
	
	
}
