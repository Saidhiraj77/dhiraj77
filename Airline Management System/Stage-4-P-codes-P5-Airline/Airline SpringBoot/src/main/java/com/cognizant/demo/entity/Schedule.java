package com.cognizant.demo.entity;

import java.time.LocalTime;
import java.util.Date;

public class Schedule {

	private Long id;
	private Long flight_id;
	private Date sdate;
	private LocalTime stime;
	private String source;
	private String destination;
	private Integer duration;
	private int repeat;
	private LocalTime atime;

	public Schedule() {
		super();
	}

	public Schedule(Long id, Long flight_id, Date sdate, LocalTime stime, String source, String destination,
			Integer duration, LocalTime atime) {
		super();
		this.id = id;
		this.flight_id = flight_id;
		this.sdate = sdate;
		this.stime = stime;
		this.source = source;
		this.destination = destination;
		this.duration = duration;
		this.atime=atime;
	}

	public Schedule(Long id, Long flight_id, Date sdate, LocalTime stime, String source, String destination,
			Integer duration, int repeat) {
		super();
		this.id = id;
		this.flight_id = flight_id;
		this.sdate = sdate;
		this.stime = stime;
		this.source = source;
		this.destination = destination;
		this.duration = duration;
		this.repeat = repeat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(Long flight_id) {
		this.flight_id = flight_id;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public LocalTime getStime() {
		return stime;
	}

	public void setStime(LocalTime stime) {
		this.stime = stime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	public LocalTime getAtime() {
		return atime;
	}

	public void setAtime(LocalTime atime) {
		this.atime = atime;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", flight_id=" + flight_id + ", sdate=" + sdate + ", stime=" + stime + ", source="
				+ source + ", destination=" + destination + ", duration=" + duration + ", repeat=" + repeat + ", atime="
				+ atime + "]";
	}
	
	
	

}
