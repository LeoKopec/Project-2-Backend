package com.skillstorm.hotel.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "room")
public class Room {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="room_id")
	private int id;
	
	@NotBlank
//	@Column(name = "room_hotel")
	@ManyToOne
	@JoinColumn(name = "room_hotel")
	@JsonManagedReference(value="hotel")
	private Hotel hotel;
	
	@NotBlank
	@Column(name = "room_name")
	private String name;
	
	@NotBlank 
	@Column(name ="room_size")
	private int size;
	
	@OneToMany(mappedBy = "room")
	@JsonBackReference(value="room")
	private Set<Reservation> reservations;
	
	@OneToMany(mappedBy = "room")
	@JsonManagedReference(value="room_price")
	private Set<Price> prices;
	
	public Room() {
		super();
	}

	// full-argument constructor
	public Room(int id, Hotel hotel, String name, int size) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.name = name;
		this.size = size;
	}

	// constructor without the auto-incremented id
	public Room(Hotel hotel, String name, int size) {
		super();
		this.hotel = hotel;
		this.name = name;
		this.size = size;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<Price> getPrices() {
		return prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

	// to-string function
	@Override
	public String toString() {
		return "Room [id=" + id + ", hotel=" + hotel.getId() + ", name=" + name + ", size=" + size + "]";
	}
	
	
}
