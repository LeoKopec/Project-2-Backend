package com.skillstorm.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skillstorm.hotel.Repository.GuestRepository;
import com.skillstorm.hotel.models.Guest;


@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository repo;

	@Override
	public Guest save(Guest guest) {
		return repo.save(guest);
	}

	

	

}
