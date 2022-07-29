package com.skillstorm.hotel.services;

import java.util.List;

import com.skillstorm.hotel.models.Reservation;

public interface ReservationService {

	List<Reservation> findByEmail();
	Reservation save(Reservation reservation);
	Reservation update(Reservation reservation);
	void deleteById(int id);
	
}