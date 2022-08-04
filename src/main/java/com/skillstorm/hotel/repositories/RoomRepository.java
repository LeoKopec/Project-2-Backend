package com.skillstorm.hotel.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.skillstorm.hotel.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	@Query("SELECT r FROM Room r WHERE r.size = :size AND r.id NOT IN (\r\n"
			+ "	SELECT res.room FROM r.reservations res\r\n"
			+ "    WHERE res.start_date BETWEEN :start AND :end\r\n"
			+ "    OR res.end_date BETWEEN :start AND :end\r\n"
			+ "    OR (res.start_date <= :start AND res.end_date >= :end)\r\n"
			+ ") AND r.hotel IN (\r\n"
			+ "	SELECT h.id FROM Hotel h WHERE h.city = :city\r\n"
			+ ")")
	public Streamable<Room> findAvailableByParams(
			@Param("start") LocalDate startDate,
			@Param("end") LocalDate endDate,
			@Param("city") String city,
			@Param("size") int roomSize
			);
	
	@Query("SELECT r FROM Room r")
	public List<Room> findAll();
	
}
