package com.example.demo.exception;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InternalServerErrorException(String message) {
		super(message);
	}

}
