package com.skillstorm.hotel.models;

public class Hotel {

	private int id;
	private String name;
	private String desc;
	private String city;
	private double rate;
	
	public Hotel() {
		
	}

	// constructor without the auto-incremented id
	public Hotel(String name, String desc, String city, double rate) {
		super();
		this.name = name;
		this.desc = desc;
		this.city = city;
		this.rate = rate;
	}

	// full-argument constructor
	public Hotel(int id, String name, String desc, String city, double rate) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.city = city;
		this.rate = rate;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	// to-string function
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", desc=" + desc + ", city=" + city + ", rate=" + rate + "]";
	}
	
}
