package com.javatech.codebaseusersapi.ui.model;

import java.io.Serializable;

public class UserAuthenticationRequestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7412390494554001086L;

	private String email;
	private String password;

	public UserAuthenticationRequestModel() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
