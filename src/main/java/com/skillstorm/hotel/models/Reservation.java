package com.skillstorm.hotel.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserv_id")
	private int id;
	
	@NotNull
//	@Column(name = "reserv_guest")
	@ManyToOne
	@JoinColumn(name = "guest_id")
	private Guest guest;
	
	@NotNull
//	@Column(name = "reserv_room")
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	@Future
	@Column(name = "reserv_start_date")
	private LocalDate start_date;
	
	@Future
	@Column(name = "reserv_end_date")
	private LocalDate end_date;
	
	@NotNull
	@Column(name = "reserv_total_price")
	private float total_price;
	
	public Reservation() {
		super();
	}

	// full-argument constructor
	public Reservation(int id, Guest guest, Room room, LocalDate start_date, LocalDate end_date, float total_price) {
		super();
		this.id = id;
		this.guest = guest;
		this.room = room;
		this.start_date = start_date;
		this.end_date = end_date;
		this.total_price = total_price;
	}

	// constructor without the auto-incremented id
	public Reservation(Guest guest, Room room, LocalDate start_date, LocalDate end_date, float total_price) {
		super();
		this.guest = guest;
		this.room = room;
		this.start_date = start_date;
		this.end_date = end_date;
		this.total_price = total_price;
	}

	// getters and setters
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

	// to-string function
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", guest=" + guest.getId() + ", room=" + room.getId() + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", total_price=" + total_price + "]";
	}
	
	
}
