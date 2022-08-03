package com.skillstorm.hotel.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.hotel.models.Hotel;
import com.skillstorm.hotel.models.Room;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
	@Query("SELECT h from Hotel h WHERE h.id =:id")
	public Hotel findById(int id);


	@Query(" SELECT room FROM Room room WHERE room.size = :size AND room.hotel.id = :id "
			+ "AND room.id NOT IN (SELECT reserv.room FROM Reservation reserv WHERE (reserv.start_date BETWEEN :start AND :end) "
			+ "OR (reserv.end_date BETWEEN :start AND :end) OR reserv.start_date<= :start and reserv.end_date >=:end) ")
	public List<Room> findRoomsByHotelId(int id, int size, LocalDate start, LocalDate end);

}
