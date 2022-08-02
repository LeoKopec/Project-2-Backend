package com.skillstorm.hotel.services;

import org.springframework.stereotype.Service;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Reservation;

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
}
