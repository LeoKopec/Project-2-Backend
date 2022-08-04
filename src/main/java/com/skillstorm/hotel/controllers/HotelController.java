package com.skillstorm.hotel.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hotel.dtos.HotelDTO;
import com.skillstorm.hotel.dtos.RoomDTO;
import com.skillstorm.hotel.models.Hotel;
import com.skillstorm.hotel.models.Room;
import com.skillstorm.hotel.services.HotelDTOMapper;
import com.skillstorm.hotel.services.HotelService;
import com.skillstorm.hotel.services.RoomDTOMapper;

@RestController
@CrossOrigin("*")
@RequestMapping("/hotels")
public class HotelController {
	
	private static Logger log = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelService service;
	@Autowired
	private RoomDTOMapper roomMapper;
	@Autowired
	private HotelDTOMapper hotelMapper;
	
//	/hotels?start=date&end=date&location=string&size=int
	@GetMapping
	public List<HotelDTO> findAll(
			@RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam String location,
			@RequestParam(name = "size") int roomSize
			) {
		log.info("Hotels requested by parameters");
		return service.findByParams(startDate, endDate, location, roomSize);
	}
	
	@GetMapping("/{id}/rooms")
	public List<RoomDTO> findRoomByIdHotelId(
			@PathVariable int id,
			@RequestParam("size") int size,
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
			) {
		log.info("Rooms requested by hotel");
		List<RoomDTO> dtos = service.findRoomsByHotelId(id, size, startDate, endDate)
				.stream().map(r -> {return this.roomMapper.toDto(r, startDate, endDate);})
				.collect(Collectors.toList());
		return dtos;
	}
	
	@GetMapping("/{id}")
	public HotelDTO findHotelById(@PathVariable int id) {
		Hotel hotel = this.service.findById(id);
		return this.hotelMapper.toDto(hotel, hotel.getRooms().stream());
	}

}
