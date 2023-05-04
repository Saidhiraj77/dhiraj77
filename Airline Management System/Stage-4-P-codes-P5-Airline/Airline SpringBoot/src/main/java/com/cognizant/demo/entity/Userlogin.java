package com.cognizant.demo.entity;

import java.util.Date;

public class Userlogin {

	private Long id;
	private String username;
	private String password;
	private String email;
	private Long pnumber;
	private Date dob;
	private String gender;
	private String role;

	public Userlogin(Long id, String username, String password, String email, Long pnumber, Date dob, String gender,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.pnumber = pnumber;
		this.dob = dob;
		this.gender = gender;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPnumber() {
		return pnumber;
	}

	public void setPnumber(Long pnumber) {
		this.pnumber = pnumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Userlogin [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", pnumber=" + pnumber + ", dob=" + dob + ", gender=" + gender + ", role=" + role + "]";
	}

	
}
