package com.cognizant.demo.entity;


	public class PassengerDetails {
		private Long id;
		private Long booking_id;
		private String salutation;
	    private String firstName;
	    private String lastName;
	    private int age;
	    private String gender;
	   
	    public PassengerDetails() { }	    
	    public PassengerDetails(Long id, long booking_id, String salutation,String firstName, String lastName, int age, String gender) {
			super();
			this.id = id;
			this.booking_id = booking_id;
			this.salutation = salutation;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.gender = gender;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getBooking_id() {
			return booking_id;
		}

		public void setBooking_id(Long booking_id) {
			this.booking_id = booking_id;
		}

		public String getSalutation() {
			return salutation;
		}

		public void setSalutation(String salutation) {
			this.salutation = salutation;
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

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "PassengerDetails [id=" + id + ", booking_id=" + booking_id + ", salutation=" + salutation + ", firstName="
					+ firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + "]";
		}

		
	   
	}



