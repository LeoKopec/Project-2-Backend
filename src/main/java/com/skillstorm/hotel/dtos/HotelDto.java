package com.skillstorm.hotel.dtos;

import com.skillstorm.hotel.models.Hotel;

public class HotelDto {
	
	private Hotel hotel;
	private double lowestPrice;
	
	public HotelDto() {
		super();
	}

	public HotelDto(Hotel hotel, double lowestPrice) {
		super();
		this.hotel = hotel;
		this.lowestPrice = lowestPrice;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

}
