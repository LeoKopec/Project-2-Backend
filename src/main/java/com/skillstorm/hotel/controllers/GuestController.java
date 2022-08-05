package com.skillstorm.hotel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hotel.models.Guest;
import com.skillstorm.hotel.services.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestService guestService;

	@PostMapping
	public Guest save(@Valid @RequestBody Guest guest) {

		return guestService.save(guest);

	}

}
