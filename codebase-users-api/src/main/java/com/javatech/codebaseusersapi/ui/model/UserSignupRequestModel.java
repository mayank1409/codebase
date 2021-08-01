package com.javatech.codebaseusersapi.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserSignupRequestModel {

	@NotBlank(message = "first name can't be blank")
	@Size(min = 3, message = "first name should be more than 3 characters")
	private String firstName;
	@NotBlank(message = "last name can't be blank")
	private String lastName;
	@NotBlank(message = "email can't be blank")
	@Email
	private String email;
	@NotBlank(message = "password can't be blank")
	@Size(min = 6, max = 15, message = "password should be between 6 and 15 characters")
	private String password;
	@NotBlank(message = "moble can't be blank")
	private String mobile;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
