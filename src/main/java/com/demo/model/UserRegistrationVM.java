package com.demo.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import static com.demo.util.ValidationConstant.FIRST_NAME_LENGTH_VIOLATION;
import static com.demo.util.ValidationConstant.FIRST_NAME_NOT_BLANK;
import static com.demo.util.ValidationConstant.USERNAME_NOT_BLANK;
import static com.demo.util.ValidationConstant.PASSWD_NOT_BLANK;
import static com.demo.util.ValidationConstant.EMAIL_NOT_BLANK;
import static com.demo.util.ValidationConstant.EMAIL_VALIDATION;
import static com.demo.util.ValidationConstant.PHONE_NUMBER_NOT_BLANK;
import static com.demo.util.ValidationConstant.PHONE_NUMBER_LENGTH;
import static com.demo.util.ValidationConstant.PASSWORD_STRENGTH;

/***
 * Model for User Registration
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public class UserRegistrationVM {

	@NotBlank(message = FIRST_NAME_NOT_BLANK)
	@Size(min = 2, message = FIRST_NAME_LENGTH_VIOLATION)
	private String firstname;
	private String lastName;
	@NotBlank(message = USERNAME_NOT_BLANK)
	private String username;
	@NotBlank(message = PASSWD_NOT_BLANK)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}", message = PASSWORD_STRENGTH)
	private String password;
	@NotBlank(message = EMAIL_NOT_BLANK)
	// @Email(message=ValidationConstant.EMAIL_VALIDATION)
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = EMAIL_VALIDATION)
	private String email;
	@NotBlank(message = PHONE_NUMBER_NOT_BLANK)
	@Size(max = 10, message = PHONE_NUMBER_LENGTH)
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
