package com.skillstorm.hotel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Reservation;
import com.skillstorm.hotel.services.ReservationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	@GetMapping("/{email}")
	public List<ReservationDTO> findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reservation create(@Valid @RequestBody Reservation reservation) {
		return service.save(reservation);
	}
	
	@PutMapping("/{id}")
	public Reservation update(@Valid @RequestBody Reservation reservation, @PathVariable int id) {
		reservation.setId(id);
		return service.update(reservation);
	}
	
	@DeleteMapping("/{id}")
	public void cancel(@PathVariable int id) {
		service.deleteById(id);
	}
}
