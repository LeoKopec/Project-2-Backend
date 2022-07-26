package com.skillstorm.hotel.models;

public class Room {
	private int id;
	private Hotel hotel;
	private String name;
	private int size;
	
	public Room() {
		super();
	}

	public Room(int id, Hotel hotel, String name, int size) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.name = name;
		this.size = size;
	}

	public Room(Hotel hotel, String name, int size) {
		super();
		this.hotel = hotel;
		this.name = name;
		this.size = size;
	}

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

	@Override
	public String toString() {
		return "Room [id=" + id + ", hotel=" + hotel.getId() + ", name=" + name + ", size=" + size + "]";
	}
	
	
}
