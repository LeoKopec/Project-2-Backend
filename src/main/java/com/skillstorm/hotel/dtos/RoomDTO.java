package com.skillstorm.hotel.dtos;

import java.util.List;

public class RoomDTO {
	
	private int id;
	private String name;
	private int size;
	
	// The prices, typically scoped by the date range
	private List<Float> prices;
	
	
	public RoomDTO() {
		super();
	}

	public RoomDTO(int id, String name, int size, List<Float> prices) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.prices = prices;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public List<Float> getPrices() {
		return prices;
	}
	
}
