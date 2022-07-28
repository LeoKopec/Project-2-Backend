package com.skillstorm.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.hotel.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
