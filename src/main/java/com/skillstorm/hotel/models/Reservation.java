package com.skillstorm.hotel.models;

import java.time.LocalDate;

public class Reservation {
	private int id;
	private Guest guest;
	private Room room;
	private LocalDate start_date;
	private LocalDate end_date;
	private float total_price;
	
	public Reservation() {
		super();
	}

	public Reservation(int id, Guest guest, Room room, LocalDate start_date, LocalDate end_date, float total_price) {
		super();
		this.id = id;
		this.guest = guest;
		this.room = room;
		this.start_date = start_date;
		this.end_date = end_date;
		this.total_price = total_price;
	}

	public Reservation(Guest guest, Room room, LocalDate start_date, LocalDate end_date, float total_price) {
		super();
		this.guest = guest;
		this.room = room;
		this.start_date = start_date;
		this.end_date = end_date;
		this.total_price = total_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", guest=" + guest.getId() + ", room=" + room.getId() + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", total_price=" + total_price + "]";
	}
	
	
}
