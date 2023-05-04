package com.cts.hms.pac.entity;

public class pacUser {
	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String gender;
	private Long age;
	private String password;
	
	public pacUser() {}
    
		public pacUser(Long id, String firstName, String lastName, String userName, String email, String gender, Long age,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.password = password;
	}




		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		@Override
	public String toString() {
		return "pacUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email + ", gender=" + gender + ", age=" + age + ", password=" + password +"]";
	}
	


}
