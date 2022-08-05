package com.skillstorm.hotel.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillstorm.hotel.models.Reservation;
import com.skillstorm.hotel.models.Room;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	@Query("select r from Reservation r where r.guest.email = ?1")
	List<Reservation> findByEmail(String email);
	
	@Query("select r from Reservation r where r.id = ?1")
	Reservation findById(int id);
	
	@Query("SELECT r FROM Reservation r\r\n"
			+ "WHERE ((r.start_date BETWEEN :start AND :end)\r\n"
			+ "OR (r.end_date BETWEEN :start AND :end)\r\n"
			+ "OR (r.start_date < :start AND r.end_date > :end))\r\n"
			+ "AND r.room = :room")
	List<Reservation> findByRoomAndDateRange(@Param("room") Room room, @Param("start") LocalDate start, @Param("end") LocalDate end);
	
}
