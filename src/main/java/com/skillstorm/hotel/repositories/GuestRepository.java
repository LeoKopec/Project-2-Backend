package com.skillstorm.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.hotel.models.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest , Integer>{

	
}
