package com.skillstorm.hotel.services;

import java.util.List;
import java.util.Optional;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Reservation;

public interface ReservationService {

	List<ReservationDTO> findByEmail(String email);
	Reservation save(ReservationDTO resDTO);
	Reservation update(ReservationDTO resDTO);
	void deleteById(int id);
	ReservationDTO findById(int id);
	
}