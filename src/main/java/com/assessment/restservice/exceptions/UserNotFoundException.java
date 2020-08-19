package com.assessment.restservice.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message) {
		super(message);
	}
}
