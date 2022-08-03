package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.skillstorm.hotel.models.Room;
import com.skillstorm.hotel.repositories.RoomRepository;


@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepository repository;

	@Override
	public Streamable<Room> findAvailableByParams(
				@Param("start") LocalDate startDate,
				@Param("end") LocalDate endDate,
				@Param("city") String city,
				@Param("size") int roomSize) {
		
		return repository.findAvailableByParams(startDate, endDate, city, roomSize);
	}

	@Override
	public List<Room> findAll() {
		return repository.findAll();
	}

	@Override
	public Room findById(int roomId) {
		// TODO Auto-generated method stub
		return this.repository.findById(roomId).get();
	}

}
