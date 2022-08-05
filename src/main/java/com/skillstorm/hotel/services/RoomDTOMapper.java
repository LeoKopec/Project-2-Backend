package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.hotel.dtos.RoomDTO;
import com.skillstorm.hotel.models.Room;

@Service
public class RoomDTOMapper {
	
	@Autowired
	RoomService service;
	
	public RoomDTO toDto(Room r) {
		return new RoomDTO(r.getId(), r.getName(), r.getSize(), null);
	}

	public RoomDTO toDto(Room r, LocalDate startDate, LocalDate endDate) {
		List<Float> prices = r.getPrices().stream().filter(price -> {
			return price.getDay().isEqual(startDate) || price.getDay().isEqual(endDate) ||
					(price.getDay().isAfter(startDate) && price.getDay().isBefore(endDate));
		}).map(price -> price.getPrice())
		.collect(Collectors.toList());

		return new RoomDTO(r.getId(), r.getName(), r.getSize(), prices);
	}
	
	public Room toRoom(RoomDTO dto) {
		return service.findById(dto.getId());
	}
	
}
