package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.List;

import com.skillstorm.hotel.dtos.HotelDTO;

public interface HotelService {
	public List<HotelDTO> findByParams(
			LocalDate startDate,
			LocalDate endDate,
			String location,
			int roomSize
//			int page,
//			int limit
			);
}
