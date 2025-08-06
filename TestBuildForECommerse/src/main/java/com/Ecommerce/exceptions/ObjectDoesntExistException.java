package com.Ecommerce.exceptions;

public class ObjectDoesntExistException extends RuntimeException {
	public ObjectDoesntExistException(String message) {
		super(message);
	}

}
