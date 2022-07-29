package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.hotel.models.Hotel;
import com.skillstorm.hotel.models.HotelDto;
import com.skillstorm.hotel.models.Room;
import com.skillstorm.hotel.repositories.HotelRepository;
import com.skillstorm.hotel.repositories.RoomRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepo;
	@Autowired
	private RoomRepository roomRepo;
	
	private static final Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Override
	public List<Room> findByParams(
			LocalDate startDate,
			LocalDate endDate,
			String city,
			int roomSize
//			int page,
//			int limit
			) {
		// TODO Auto-generated method stub
		// Hotels and their lowest available room price 
		// first, we get lowest priced rooms in each hotel
		log.trace("Finding available rooms by parameters.");
		return this.roomRepo.findAvailableByParams(startDate, endDate, city, roomSize);
		
		
//		// prices inner joined with rooms filtered by date range grouped
//		List<Room> cheapestRooms = hotelRepo.findLowestPricedByParams(startDate, endDate, city, roomSize, page, limit);
//		// second, 
//		ArrayList<HotelDto> hotelDtos = new ArrayList<>(cheapestRooms.size());
//		for (Room room: cheapestRooms) {
//			hotelDtos.add(new HotelDto(room.getHotel(), 0));
//		}
//		return null;
	}

}
