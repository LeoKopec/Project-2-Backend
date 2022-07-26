package com.skillstorm.hotel.models;

public class Room {
	private int id;
	private Hotel hotel;
	private String name;
	private int size;
	
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

	// to-string function
	@Override
	public String toString() {
		return "Room [id=" + id + ", hotel=" + hotel.getId() + ", name=" + name + ", size=" + size + "]";
	}
	
	
}
