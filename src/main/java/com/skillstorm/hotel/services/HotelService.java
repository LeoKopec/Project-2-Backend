package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.List;

import com.skillstorm.hotel.dtos.HotelDTO;
import com.skillstorm.hotel.models.Hotel;
import com.skillstorm.hotel.models.Room;

public interface HotelService {
	public List<HotelDTO> findByParams(
			LocalDate startDate,
			LocalDate endDate,
			String location,
			int roomSize
//			int page,
//			int limit
			);


	public Hotel findById(int id);
	
	public List<Room> findRoomsByHotelId(int id, int size, LocalDate start, LocalDate end);

}
