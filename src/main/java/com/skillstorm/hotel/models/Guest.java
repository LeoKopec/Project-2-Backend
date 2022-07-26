package com.skillstorm.hotel.models;

public class Guest {

	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	
	public Guest() {
		
	}

	// constructor without the auto-incremented id
	public Guest(String first_name, String last_name, String email, String phone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
	}

	// full-argument constructor
	public Guest(int id, String first_name, String last_name, String email, String phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	// to-string function
	@Override
	public String toString() {
		return "Guest [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
}
