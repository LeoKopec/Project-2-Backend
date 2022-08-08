package com.skillstorm.hotel.services;

import java.util.Optional;

import com.skillstorm.hotel.models.Guest;

public interface GuestService {

	Guest save(Guest guest);
	
	Optional<Guest> findById(int id);

}
