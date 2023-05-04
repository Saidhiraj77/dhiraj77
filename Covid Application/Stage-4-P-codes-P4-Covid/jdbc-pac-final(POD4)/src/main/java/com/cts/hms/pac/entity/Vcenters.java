package com.cts.hms.pac.entity;

public class Vcenters {
	private Long id;
	private String name;
	private Long pinCode;
	
	public Vcenters() {}

	public Vcenters(Long id, String name, Long pinCode) {
		super();
		this.id = id;
		this.name = name;
		this.pinCode = pinCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", pinCode=" + pinCode + "]";
	}
}
