package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.hotel.dtos.HotelDTO;
import com.skillstorm.hotel.models.Hotel;
import com.skillstorm.hotel.models.Room;
import com.skillstorm.hotel.repositories.HotelRepository;
import com.skillstorm.hotel.repositories.RoomRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private HotelDTOMapper mapper;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	private static final Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Override
	public List<HotelDTO> findByParams(
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
		// This is where we would paginate
		Map<Hotel, List<Room>> roomsByHotel = this.roomRepo.findAvailableByParams(roomSize, city, startDate, endDate)
				.stream().collect(Collectors.groupingBy(Room::getHotel));
		List<HotelDTO> hotelDtos = roomsByHotel.entrySet().stream().map(entry -> {
			return this.mapper.toDto(entry.getKey(), entry.getValue().stream(), startDate, endDate);
		}).collect(Collectors.toList());
		return hotelDtos;
	}

	@Override
	public Hotel findById(int id) {
		return hotelRepository.findById(id);
	}

	@Override
	public List<Room> findRoomsByHotelId(int id, int size, String city, LocalDate start, LocalDate end) {
		return hotelRepository.findRoomsByHotelId(id, size, city, start, end);
	}
	
	
	

}
