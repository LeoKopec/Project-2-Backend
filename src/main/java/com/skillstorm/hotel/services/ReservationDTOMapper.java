package com.skillstorm.hotel.services;

import org.springframework.stereotype.Service;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Guest;
import com.skillstorm.hotel.models.Hotel;
import com.skillstorm.hotel.models.Reservation;
import com.skillstorm.hotel.models.Room;

@Service
public class ReservationDTOMapper {

	public ReservationDTO toDto(Reservation reservation) {
		
		return new ReservationDTO(reservation.getId(), 
								  reservation.getGuest().getFirst_name(), 
								  reservation.getGuest().getLast_name(),
								  reservation.getStart_date(), 
								  reservation.getEnd_date(), 
								  reservation.getRoom().getHotel().getName(),
								  reservation.getRoom().getHotel().getCity(), 
								  reservation.getRoom().getName(), 
								  reservation.getRoom().getSize(),
								  reservation.getTotal_price());
	}
	
	public ReservationDTO fullToDto(Reservation reservation) {
		
		return new ReservationDTO(reservation.getId(),
								  reservation.getGuest().getId(),
								  reservation.getGuest().getFirst_name(),
								  reservation.getGuest().getLast_name(),
								  reservation.getGuest().getEmail(),
								  reservation.getGuest().getPhone(),
								  reservation.getRoom().getId(),
								  reservation.getRoom().getHotel().getId(),
								  reservation.getRoom().getHotel().getName(),
								  reservation.getRoom().getHotel().getDesc(),
								  reservation.getRoom().getHotel().getCity(),
								  reservation.getRoom().getHotel().getRate(),
								  reservation.getRoom().getName(),
								  reservation.getRoom().getSize(),
								  reservation.getStart_date(),
								  reservation.getEnd_date(),
								  reservation.getTotal_price());
	}
	
	public Reservation toReservation(ReservationDTO resDto) {
		return new Reservation(resDto.getId(),
								new Guest(resDto.getGuest_id(), resDto.getFirst_name(), resDto.getLast_name(), resDto.getEmail(), resDto.getPhone()),
								new Room(resDto.getRoom_id(), new Hotel(resDto.getHotel_id(), resDto.getHotel(), resDto.getDesc(), resDto.getCity(), resDto.getRating()), 
										 resDto.getRoom_name(), resDto.getRoom_size()),
								resDto.getStart_date(),
								resDto.getEnd_date(),
								(float) resDto.getTotal_price());
	}
	
	public Guest toGuest(ReservationDTO resDto) {
		return new Guest(resDto.getFirst_name(), resDto.getLast_name(), resDto.getEmail(), resDto.getPhone());
	}
	
}
