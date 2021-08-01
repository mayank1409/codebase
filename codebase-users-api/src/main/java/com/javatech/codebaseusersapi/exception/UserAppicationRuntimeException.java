package com.javatech.codebaseusersapi.exception;

import org.springframework.http.HttpStatus;

public class UserAppicationRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final String DEFAULT_ERROR_MESSAGE = "Something Bad Happened";
	private static final long serialVersionUID = -6027499949872852216L;
	private String message;
	private int status;
	private long timestamp;

	public UserAppicationRuntimeException() {
		this(DEFAULT_ERROR_MESSAGE);
	}

	public UserAppicationRuntimeException(String message) {
		this(message, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	public UserAppicationRuntimeException(String message, int status) {
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
