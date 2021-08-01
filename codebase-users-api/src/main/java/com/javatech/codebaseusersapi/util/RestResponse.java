package com.javatech.codebaseusersapi.util;

public class RestResponse<T> {

	private long timestamp;
	private int status;
	private T body;

	public RestResponse() {
	}

	public RestResponse(long timestamp, int status, T body) {
		this.timestamp = timestamp;
		this.status = status;
		this.body = body;
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

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
