package com.skillstorm.hotel.models;

import java.time.LocalDate;

public class Price {
	private Room room;
	private LocalDate day;
	private float price;
	
	public Price() {
		super();
	}

	public Price(Room room, LocalDate day, float price) {
		super();
		this.room = room;
		this.day = day;
		this.price = price;
	}

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

	@Override
	public String toString() {
		return "Price [room=" + room.getId() + ", day=" + day + ", price=" + price + "]";
	}
	
}
