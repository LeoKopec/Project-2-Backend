package com.skillstorm.hotel.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "price")
public class Price implements Serializable{
	
	@Id 
//	@Column(name="price_room")
	@NotBlank
	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;
	
	@Id
	@NotBlank
	@Column(name="price_day")
	private LocalDate day;
	
	
	@NotBlank
	@Column(name="price")
	private float price;
	
	public Price() {
		super();
	}

	// full-argument constructor
	public Price(Room room, LocalDate day, float price) {
		super();
		this.room = room;
		this.day = day;
		this.price = price;
	}

	// getters and setters
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	// to-string function
	@Override
	public String toString() {
		return "Price [room=" + room.getId() + ", day=" + day + ", price=" + price + "]";
	}
	
}
