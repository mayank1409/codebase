package com.javatech.codebaseusersapi.ui.model;

import java.io.Serializable;

public class UserAuthenticationResponseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7281530683082128635L;
	private String jwtToken;
	
	public UserAuthenticationResponseModel() {
	}

	public UserAuthenticationResponseModel(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
}
