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

//	@Query("select r from Room r where ?1 between ")
//	SELECT * FROM tblRoom AS r  
//	WHERE RoomID NOT IN  
//	 (SELECT AssignedRoomID as RoomID From tblBooking  
//	  WHERE assignedroomid IS NOT NULL AND assignedroomid = r.roomid AND 
//	    (BeginDate < @BookingInquiryEndDate AND EndDate > @BookingInquiryBeginDate)  
//	 )
	
////	Find the lowest priced available rooms for each hotel
//	@Query("SELECT DISTINCT r FROM Room r WHERE r.id NOT IN (select)" +
//			"where r.hotel.city = :city" +
//			"and r.size = :size" +
////			Select a room for each hotel
////			with the lowest price over the period
////			rooms without an overlapping reservation
//			"SELECT r FROM Room r WHERE r.hotel.city = :city AND r.size = :size AND r.id NOT IN " +
////			rooms with an overlapping reservation
//			"(SELECT res.room.id FROM r.reservations res " + 
//			"WHERE (res.start_date > :start AND res.start_date < :end) OR " +
//			"(res.end_date > :start AND res.end_date < :end) OR " +
//			"(res.start_date <= :start AND res.end_date >= :end))"
//			)
//	public List<Room> findLowestPricedByParams(
//			@Param("start") LocalDate startDate,
//			@Param("end") LocalDate endDate,
//			@Param("city") String city,
//			@Param("size") int roomSize,
//			@Param("page") int page,
//			@Param("limit") int limit);
	
	
	@Query("SELECT h from Hotel h WHERE h.id =:id")
	public Hotel findById(int id);


	@Query(" SELECT room FROM Room room WHERE room.size = :size AND room.hotel.id = :id "
			+ "AND room.id NOT IN (SELECT reserv.room FROM Reservation reserv WHERE (reserv.start_date BETWEEN :start AND :end) "
			+ "OR (reserv.end_date BETWEEN :start AND :end) OR reserv.start_date<= :start and reserv.end_date >=:end) ")
	public List<Room> findRoomsByHotelId(int id, int size, LocalDate start, LocalDate end);

}
