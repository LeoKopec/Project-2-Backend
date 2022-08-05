package com.skillstorm.hotel.controllers;

import java.time.LocalDate;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hotel.dtos.RoomDTO;
import com.skillstorm.hotel.models.Room;
import com.skillstorm.hotel.services.RoomDTOMapper;
import com.skillstorm.hotel.services.RoomService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rooms/")

public class RoomController {
		
	@Autowired
	private RoomService service;
	@Autowired
	private RoomDTOMapper mapper;
	
//	/rooms/{id}?start=DATE&end=DATE
	@GetMapping("/{id}")
	public RoomDTO getById(
			@PathVariable(name = "id") int roomId,
			@RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
			) {
		Room room = service.findById(roomId);
		return this.mapper.toDto(room, startDate, endDate);
	}
	
//	/rooms/{id}/pricing?start=DATE&end=DATE
	@GetMapping("/{id}/pricing")
	public double getRoomPricing(
			@PathVariable(name = "id") int roomId,
			@RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
			) {
		Room room = service.findById(roomId);
		OptionalDouble optD = room.getPrices().stream().filter(price -> {
			return price.getDay().isEqual(startDate) || price.getDay().isEqual(endDate) ||
					(price.getDay().isAfter(startDate) && price.getDay().isBefore(endDate));
		}).mapToDouble(price -> price.getPrice())
		.reduce((p1, p2) -> {return p1 + p2;});
		return optD.isPresent() ? optD.getAsDouble() : 0;
	}
	
}
