package com.skillstorm.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.hotel.models.Reservation;
import com.skillstorm.hotel.repositories.ReservationRepository;

@Service
@Primary
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository repository;
	
	@Override
	public List<Reservation> findByEmail() {
		return repository.findAll();
	}
	
	@Override
	public Reservation save(Reservation reservation) {
		return repository.save(reservation);
	}

	@Override
	public Reservation update(Reservation reservation) {
		return repository.save(reservation);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}


}