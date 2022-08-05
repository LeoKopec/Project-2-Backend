package com.skillstorm.hotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.hotel.dtos.ReservationDTO;
import com.skillstorm.hotel.models.Guest;
import com.skillstorm.hotel.models.Reservation;
import com.skillstorm.hotel.repositories.GuestRepository;
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
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = { OptimisticLockingFailureException.class })
	public Reservation save(ReservationDTO resDTO) throws OptimisticLockingFailureException {
		Reservation newReservation = mapper.toReservation(resDTO);
		newReservation.setGuest(this.guestService.save(newReservation.getGuest()));
		if (repository.existsByRoomAndDateRange(
				newReservation.getRoom().getId(),
				newReservation.getStart_date(),
				newReservation.getEnd_date())) {
			throw new ReservationOverlapException("a conflicting reservation was found");
		} else {
			return repository.save(newReservation);
		}
	}

	@Override
	public Reservation update(ReservationDTO resDTO) {
		Guest newGuest = mapper.toGuest(resDTO);
		Guest guest = guestService.save(newGuest);
		System.out.println(guest.getId());
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