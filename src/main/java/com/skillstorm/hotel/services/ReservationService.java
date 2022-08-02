package com.skillstorm.hotel.services;

import java.util.List;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Reservation;

public interface ReservationService {

	List<ReservationDTO> findByEmail(String email);
	Reservation save(Reservation reservation);
	Reservation update(Reservation reservation);
	void deleteById(int id);
	
}