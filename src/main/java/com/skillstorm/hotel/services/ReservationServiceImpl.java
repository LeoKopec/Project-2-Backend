package com.skillstorm.hotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Reservation;
import com.skillstorm.hotel.repositories.ReservationRepository;
import com.skillstorm.hotel.services.exceptions.ReservationOverlapException;

@Service
@Primary
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository repository;
	@Autowired
	private ReservationDTOMapper mapper;
	@Autowired
	private GuestService guestService;
	
	@Override
	public List<ReservationDTO> findByEmail(String email) {
		List<Reservation> reservations = repository.findByEmail(email);
		List<ReservationDTO> reservationsDto = new ArrayList<>();
		for (Reservation reservation : reservations) {
			ReservationDTO myDto = mapper.fullToDto(reservation);
			reservationsDto.add(myDto);
		}
		return reservationsDto;
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Reservation save(ReservationDTO resDTO) {
		Reservation newReservation = mapper.toReservation(resDTO);
		newReservation.setGuest(this.guestService.save(newReservation.getGuest()));
		if (repository.findByRoomAndDateRange(
				newReservation.getRoom(),
				newReservation.getStart_date(),
				newReservation.getEnd_date()).size() > 0) {
			throw new ReservationOverlapException("a conflicting reservation was found");
		}
		return repository.save(newReservation);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Reservation update(ReservationDTO resDTO) {
		Reservation newReservation = mapper.toReservation(resDTO);
		newReservation.setGuest(this.guestService.save(newReservation.getGuest()));
		List<Reservation> overlapping = repository.findByRoomAndDateRange(
				newReservation.getRoom(),
				newReservation.getStart_date(),
				newReservation.getEnd_date());
		overlapping = overlapping.stream().filter(res -> {
			return res.getId() != newReservation.getId();
		}).collect(Collectors.toList());
		if (overlapping.size() > 0) {
			throw new ReservationOverlapException("a conflicting reservation was found");
		}
		return repository.save(newReservation);
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