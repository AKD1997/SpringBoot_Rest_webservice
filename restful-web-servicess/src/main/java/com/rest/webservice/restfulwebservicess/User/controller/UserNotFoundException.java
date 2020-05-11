package com.rest.webservice.restfulwebservicess.User.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 933975855124311831L;

	public UserNotFoundException(String mesage) {
		super();
	}

}
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 class Servererror extends RuntimeException {

	private static final long serialVersionUID = 933975855124311831L;

	public Servererror(String mesage) {
		super();
	}

}
