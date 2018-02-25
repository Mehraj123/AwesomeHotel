package com.demo.successcode;

/***
 * Success code of class {@code UserRegistration}
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public enum UserRegistrationSuccessCode {
	
	USER_CREATED("SCS100", "User created successfully"),
	USER_UPDATED("SCS101", "User updated successfully"),
	USER_DELETED("SCS102", "User deleted successfully"),
	USER_FETCHED("SCS103", "User fetched successfully"),
	
	
	USER_LOGIN_SUCCESS("SCS200", "User Login successfully"),
	USER_FAILED("SCS201", "User Login failed");
	
	private final String code;
	private final String message;
	
	
	private UserRegistrationSuccessCode(String code, String message) {
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
