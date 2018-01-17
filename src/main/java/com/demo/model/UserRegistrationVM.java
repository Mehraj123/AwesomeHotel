package com.demo.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.demo.util.ValidationConstant;

/***
 * Model for User Registration
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public class UserRegistrationVM {

	@NotBlank(message=ValidationConstant.FIRST_NAME_NOT_BLANK)
	@Size(min=2, message=ValidationConstant.FIRST_NAME_LENGTH_VIOLATION)
	private String firstname;
	private String lastName;
	@NotBlank(message=ValidationConstant.USERNAME_NOT_BLANK)
	private String username;
	@NotBlank(message=ValidationConstant.PASSWD_NOT_BLANK)
	@Size(min=8, message=ValidationConstant.EMAIL_VALIDATION)
	//@Pattern(regexp= "^[a-zA-Z][0-9]\\w{8}$")
	private String password;
	@NotBlank(message=ValidationConstant.EMAIL_NOT_BLANK)
	@Email(message=ValidationConstant.EMAIL_VALIDATION)
	private String email;
	@NotBlank(message=ValidationConstant.PHONE_NUMBER_NOT_BLANK)
	@Size(max=10,message=ValidationConstant.PHONE_NUMBER_LENGTH)
	private String phoneNumber;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
