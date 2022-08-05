package com.skillstorm.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.skillstorm.hotel.models.Guest;
import com.skillstorm.hotel.repositories.GuestRepository;

@Service
@Primary
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository repo;

	@Override
	public Guest save(Guest guest) {
		return repo.save(guest);
	}

}
