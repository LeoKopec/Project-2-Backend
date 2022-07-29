package com.skillstorm.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.hotel.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	@Query("select r from Reservation r where r.guest.email = ?1")
	List<Reservation> findByEmail(String email);
}
