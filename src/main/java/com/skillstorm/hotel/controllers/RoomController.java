package com.skillstorm.hotel.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hotel.models.Room;
import com.skillstorm.hotel.services.RoomService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rooms/")

public class RoomController {
		
	private static final Logger log = LoggerFactory.getLogger(RoomController.class);

	@Autowired
	private RoomService service;

//	@GetMapping("{id}/rooms?start=date&end=date&size=int")
//	public Streamable<Room> findAvailableByParams(
//			@PathVariable int id,
//			@RequestParam("start") LocalDate startDate,
//			@RequestParam("end") LocalDate endDate,
//			@RequestParam("city") String city,
//			@RequestParam("size") int roomSize) {
//		
//		return service.findAvailableByParams(startDate, endDate, city, roomSize);
//		
//	}
	
//	@GetMapping("/rooms")
//	public List<Room> findAll() {
//		System.out.println("here");
//		return service.findAll();
//	}
	
	@GetMapping("/rooms")
	public List<Room> findSomeRoom(@RequestParam("size") int size, @RequestParam("city") String city, @RequestParam("start") String start, @RequestParam("end") String end ) {
		LocalDate startDate = LocalDate.parse(start);
		LocalDate endDate = LocalDate.parse(end);
		
		return service.findAvailableByParams(size, city, startDate, endDate);
	}
	
//	/rooms/{id}/pricing?start=DATE&end=DATE
	@GetMapping("/{id}")
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
