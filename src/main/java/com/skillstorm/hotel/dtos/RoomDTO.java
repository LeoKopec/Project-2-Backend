package com.skillstorm.hotel.dtos;

public class RoomDto {
	
	private int id;
	private String city;
	private int roomSize;
	private double rate;
	
	
	public RoomDto() {
		super();
	}
	
	public RoomDto(int id, String city, int roomSize, double rate) {
		super();
		this.id = id;
		this.city = city;
		this.roomSize = roomSize;
		this.rate = rate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the roomSize
	 */
	public int getRoomSize() {
		return roomSize;
	}

	/**
	 * @param roomSize the roomSize to set
	 */
	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
