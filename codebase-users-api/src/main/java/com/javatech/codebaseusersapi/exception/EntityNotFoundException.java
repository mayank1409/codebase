package com.javatech.codebaseusersapi.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3658461419753472347L;
	private static final String DEFAULT_ERROR_MESSAGE = "Entity not Exists";
	private String message;
	private int status;
	private long timestamp;

	public EntityNotFoundException() {
		this(DEFAULT_ERROR_MESSAGE);
	}

	public EntityNotFoundException(String message) {
		this(message, HttpStatus.CONFLICT.value());
	}

	public EntityNotFoundException(String message, int status) {
		this.message = message;
		this.status = status;
		this.timestamp = System.currentTimeMillis();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
