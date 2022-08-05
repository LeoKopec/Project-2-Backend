package com.skillstorm.hotel.services;

import java.time.LocalDate;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.skillstorm.hotel.dtos.HotelDTO;
import com.skillstorm.hotel.models.Hotel;
import com.skillstorm.hotel.models.Room;

@Service
public class HotelDTOMapper {
	
	public HotelDTO toDto(Hotel hotel, Stream<Room> rooms) {
		final AtomicInteger num = new AtomicInteger();
		if (rooms != null) {
			rooms.peek(room -> num.incrementAndGet());
		}
		return new HotelDTO(hotel.getId(), hotel.getName(), hotel.getDesc(),
				hotel.getCity(), hotel.getRate(), num.get(), 0);
	}
	
	public HotelDTO toDto(Hotel hotel, Stream<Room> rooms, LocalDate start, LocalDate end) {
		final AtomicInteger num = new AtomicInteger();
		double lowest = 0;
		if (rooms != null) {
			OptionalDouble opt = rooms
			.peek(room -> num.incrementAndGet())
			.mapToDouble(room -> {
				OptionalDouble optD = room.getPrices().stream().filter(price -> {
					return price.getDay().isEqual(start) || price.getDay().isEqual(end) ||
							(price.getDay().isAfter(start) && price.getDay().isBefore(end));
				}).mapToDouble(price -> price.getPrice())
				.reduce((p1, p2) -> {return p1 + p2;});
				return optD.isPresent() ? optD.getAsDouble() : 0;
			})
			.min();
			if (opt.isPresent()) {
				lowest = opt.getAsDouble();
			}
		}
		return new HotelDTO(hotel.getId(), hotel.getName(), hotel.getDesc(),
				hotel.getCity(), hotel.getRate(), num.get(), lowest);
	}
	
	public Hotel toHotel(HotelDTO dto) {
		return new Hotel(dto.getId(), dto.getName(), dto.getDesc(), dto.getCity(), dto.getRate());
	}
	
}
