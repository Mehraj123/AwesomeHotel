package com.demo.successcode;

/***
 * Success code of class {@code UserLogin}
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public enum UserLoginSuccessCode {

	USER_LOGIN("SCS200", "User Login successfully"),;

	private final String code;
	private final String message;

	private UserLoginSuccessCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
