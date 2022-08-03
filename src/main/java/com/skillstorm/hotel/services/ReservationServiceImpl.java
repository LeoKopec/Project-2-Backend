package com.skillstorm.hotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Reservation;
import com.skillstorm.hotel.repositories.ReservationRepository;

@Service
@Primary
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository repository;
	@Autowired
	private ReservationDTOMapper mapper;
	
	@Override
	public List<ReservationDTO> findByEmail(String email) {
		List<Reservation> reservations = repository.findByEmail(email);
		List<ReservationDTO> reservationsDto = new ArrayList<>();
		for (Reservation reservation : reservations) {
			ReservationDTO myDto = mapper.toDto(reservation);
			reservationsDto.add(myDto);
		}
		return reservationsDto;
	}
	
	@Override
	public Reservation save(Reservation reservation) {
		return repository.save(reservation);
	}

	@Override
	public Reservation update(ReservationDTO resDTO) {
		Reservation myReservation = mapper.toReservation(resDTO);
		return repository.save(myReservation);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	@Override
	public ReservationDTO findById(int id) {
		Reservation reservation = repository.findById(id);
		ReservationDTO resDTO = mapper.fullToDto(reservation);
		return resDTO;
	}


}