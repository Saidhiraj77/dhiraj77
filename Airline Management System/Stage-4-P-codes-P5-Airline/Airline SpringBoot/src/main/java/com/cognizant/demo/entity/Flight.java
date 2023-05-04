package com.cognizant.demo.entity;

public class Flight {
	
	private Integer id;
	private String flightNumber;
	private String flightName;
	private String model;
	private String type;
	private Integer economySeats;
	private Integer businessSeats;
	private Integer firstClassSeats;
	public Flight() {}
	

	public Flight(Integer id, String flightNumber, String flightName, String model, String type, Integer economySeats,
			Integer businessSeats, Integer firstClassSeats) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.model = model;
		this.type = type;
		this.economySeats = economySeats;
		this.businessSeats = businessSeats;
		this.firstClassSeats = firstClassSeats;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(Integer economySeats) {
		this.economySeats = economySeats;
	}

	public Integer getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(Integer businessSeats) {
		this.businessSeats = businessSeats;
	}

	public Integer getFirstClassSeats() {
		return firstClassSeats;
	}


	public void setFirstClassSeats(Integer firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}


	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", flightName=" + flightName + ", model=" + model
				+ ", type=" + type + ", economySeats=" + economySeats + ", businessSeats=" + businessSeats
				+ ", firstClassSeats=" + firstClassSeats + "]";
	}


	
}
