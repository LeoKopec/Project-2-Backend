package com.skillstorm.hotel.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.skillstorm.hotel.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	
//	@Query("SELECT r FROM Room r WHERE r.size =:size AND \n"
//			+ "	r.id NotIn (SELECT res.room FROM r.reservations res WHERE (res.start_date BETWEEN :start AND :end)\n"
//			+ "	OR (res.end_date BETWEEN :start AND :end)\n"
//			+ "	OR (res.start_date <= :start AND res.end_date >= :end))\n"
//			+ "    AND r.hotel IN (SELECT h.id FROM Hotel h WHERE h.city = :city))")
//	public Streamable<Room> findAvailableByParams(
//			@Param("start") LocalDate startDate,
//			@Param("end") LocalDate endDate,
//			@Param("city") String city,
//			@Param("size") int roomSize
//			);
	
	@Query("SELECT r FROM Room r")
	public List<Room> findAll();
	
	
	@Query("SELECT r FROM Room r WHERE r.size =:size AND r.hotel IN (SELECT h.id FROM Hotel h WHERE h.city =:city) "
			+ "AND r.id NOT IN (SELECT reserv.room FROM Reservation reserv WHERE (reserv.start_date BETWEEN :start AND :end) OR (reserv.end_date BETWEEN :start AND :end)) ")
//			+ "AND r.id NOT IN (SELECT reserv.id FROM Reservation reserv WHERE (reserv.start_date BETWEEN :start AND :end) OR (reserv.end_date BETWEEN :start AND :end)) ")
//	@Query(value = "select * from room where room_size=:size", nativeQuery = true )
	public List<Room> findAvailableByParams(int size, String city, LocalDate start, LocalDate end);
	
}
