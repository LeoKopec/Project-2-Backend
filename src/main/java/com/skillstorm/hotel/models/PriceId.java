package com.skillstorm.hotel.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PriceId implements Serializable {
	
	private static final long serialVersionUID = 1875756392614153411L;
	private Room room;
	private LocalDate day;
	
	public PriceId() {
		super();
	}

	public PriceId(Room room, LocalDate day) {
		super();
		this.room = room;
		this.day = day;
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, room.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceId other = (PriceId) obj;
		return Objects.equals(day, other.day) && room.getId() == other.room.getId();
	}
	
}
