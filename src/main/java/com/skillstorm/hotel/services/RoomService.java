package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.util.Streamable;

import com.skillstorm.hotel.models.Room;

public interface RoomService {

//	Streamable<Room> findAvailableByParams(LocalDate startDate, LocalDate endDate, String city, int roomSize);
	
	List<Room> findAll();

	List<Room> findAvailableByParams(int size, String city, LocalDate start, LocalDate end);
}
