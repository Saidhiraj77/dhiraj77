package com.example.demo.model;

public class MyUser
{
	private Long userId;
	private String username;
	private String email;
	private String phone;
	private String gender;
	private String password;
	private String role;

	public MyUser() {}

	public MyUser(Long userId)
	{
		super();
		this.userId= userId;
		
	}
	public MyUser(Long userId, String username, String email, String phone, String gender, String password,
			String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MyUser [userId=" + userId + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", gender=" + gender + ", password=" + password + ", role=" + role + "]";
	}

	
}
