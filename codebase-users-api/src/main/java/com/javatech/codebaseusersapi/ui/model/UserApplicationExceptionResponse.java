package com.javatech.codebaseusersapi.ui.model;

import java.util.ArrayList;
import java.util.List;

public class UserApplicationExceptionResponse {

	private long timestamp;
	private int status;
	private List<String> messages;

	public UserApplicationExceptionResponse() {
	}

	public UserApplicationExceptionResponse(List<String> messages) {
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getMessages() {
		if (messages == null) {
			messages = new ArrayList<>();
		}
		return messages;
	}

	public void setMessage(List<String> messages) {
		this.messages = messages;
	}

}
