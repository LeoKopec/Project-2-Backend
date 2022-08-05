package com.skillstorm.hotel.services.exceptions;

import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ReservationOverlapException extends ConcurrencyFailureException {

	private static final long serialVersionUID = -5813437360928121849L;
	
	public ReservationOverlapException(String msg) {
		super(msg);
	}

}
