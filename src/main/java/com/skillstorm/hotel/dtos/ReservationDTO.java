package com.skillstorm.hotel.dtos;

import java.time.LocalDate;

public class ReservationDTO {

	private int id;
	private String first_name;
	private String last_name;
	private LocalDate start_date;
	private LocalDate end_date;
	private String hotel;
	private String city;
	private String room_name;
	private int room_size;
	private double total_price;
	
	public ReservationDTO() {
		
	}

	public ReservationDTO(int id, String first_name, String last_name, LocalDate start_date, LocalDate end_date,
			String hotel, String city, String room_name, int room_size, double total_price) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.hotel = hotel;
		this.city = city;
		this.room_name = room_name;
		this.room_size = room_size;
		this.total_price = total_price;
	}

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

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getRoom_size() {
		return room_size;
	}

	public void setRoom_size(int room_size) {
		this.room_size = room_size;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
}
