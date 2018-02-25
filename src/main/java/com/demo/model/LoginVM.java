package com.demo.model;

import org.hibernate.validator.constraints.NotBlank;

import com.demo.util.ValidationConstant;

/**
 * View Model object for storing a demo's credentials.
 * 
 * @author Devendra.Kumar
 * @version 1.0
 */
public class LoginVM {

	@NotBlank(message=ValidationConstant.USERNAME_NOT_BLANK)
	private String username;

	private String mobilenumber;

	@NotBlank(message=ValidationConstant.PASSWD_NOT_BLANK)
	private String password;

	private Boolean rememberMe;

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

	public Boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "LoginVM{" + "username='" + username + '\'' + ", rememberMe=" + rememberMe + '}';
	}
}

