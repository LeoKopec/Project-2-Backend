package com.skillstorm.hotel.controllers;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hotel.dtos.HotelDTO;
import com.skillstorm.hotel.services.HotelService;

@RestController
@CrossOrigin("*")
@RequestMapping("/hotels")
public class HotelController {
	
	private static Logger log = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelService service;
	
//	/hotels?start=date&end=date&location=string&size=int
	@GetMapping
	public List<HotelDTO> findAll(
			@RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam String location,
			@RequestParam(name = "size") int roomSize
//			@RequestParam(defaultValue = "1") int page,
//			@RequestParam(defaultValue = "10") int limit
			) {
		log.info("Hotels requested by parameters");
		return service.findByParams(startDate, endDate, location, roomSize);
	}

}
