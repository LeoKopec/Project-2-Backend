package com.skillstorm.hotel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hotel.models.Guest;



@RestController
@RequestMapping("/guest")
public class GuestController {

	@PostMapping
	public Guest save(@Valid @RequestBody Guest guest){
		
		return null;
	}
	
}
