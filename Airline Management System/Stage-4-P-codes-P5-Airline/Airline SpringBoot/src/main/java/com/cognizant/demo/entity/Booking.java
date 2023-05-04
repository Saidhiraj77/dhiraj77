
package com.cognizant.demo.entity;

public class Booking {

	private Long id;
	private Long schedule_id;
	private String classtype;
	private Integer passengers;
	private Long user_id;

	public Booking() {
		super();
	}

	public Booking(Long id, Long schedule_id, String classtype, Integer passengers, Long user_id) {
		super();
		this.id = id;
		this.schedule_id = schedule_id;
		this.classtype = classtype;
		this.passengers = passengers;
		this.user_id = user_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Long schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

}