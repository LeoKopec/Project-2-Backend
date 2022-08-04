package com.skillstorm.hotel.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private int id;
	
	@NotBlank
	@Size(max = 45)
	@Column(name = "hotel_name")
	private String name;
	
	@Size(max = 300)
	@Column(name = "hotel_desc")
	private String desc;
	
	@NotBlank
	@Size(max = 45)
	@Column(name = "hotel_city")
	private String city;
	
	@DecimalMin(value = "1.0")
	@DecimalMax(value = "5.0")
	@Column(name = "hotel_rate")
	private double rate;
	
	@OneToMany(mappedBy = "hotel")
	@JsonManagedReference(value="hotel")
	private Set<Room> rooms;
	
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

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	// to-string function
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", desc=" + desc + ", city=" + city + ", rate=" + rate + "]";
	}
	
}
