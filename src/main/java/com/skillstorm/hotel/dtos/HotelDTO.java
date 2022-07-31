package com.skillstorm.hotel.dtos;

public class HotelDTO {
	
	// Hotel values
	private int id;
	private String name;
	private String desc;
	private String city;
	private double rate;
	
	// Derived values
	// The number of rooms, context dependent, may be based on criterion
	private int numberRooms;
	// The lowest priced room, may not be set in certain contexts
	private double lowestPrice;
	
	public HotelDTO() {
		super();
	}

	public HotelDTO(int id, String name, String desc, String city, double rate) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.city = city;
		this.rate = rate;
	}

	public HotelDTO(int id, String name, String desc, String city, double rate, int numberRooms, double lowestPrice) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.city = city;
		this.rate = rate;
		this.numberRooms = numberRooms;
		this.lowestPrice = lowestPrice;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getCity() {
		return city;
	}

	public double getRate() {
		return rate;
	}

	public int getNumberRooms() {
		return numberRooms;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

}
