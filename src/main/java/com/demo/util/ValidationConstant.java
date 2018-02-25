package com.demo.util;

public final class ValidationConstant {

	private ValidationConstant() {
	}

	public static final String FIRST_NAME_NOT_BLANK = "VLD1000";
	public static final String FIRST_NAME_LENGTH_VIOLATION = "VLD1001";
	public static final String USERNAME_NOT_BLANK = "VLD1002";
	public static final String PASSWD_NOT_BLANK = "VLD1003";
	public static final String EMAIL_NOT_BLANK = "VLD1004";
	public static final String PHONE_NUMBER_NOT_BLANK = "VLD1005";
	public static final String EMAIL_VALIDATION = "VLD1006";
	public static final String PHONE_NUMBER_LENGTH = "VLD1007";
	public static final String MINIMUM_PASSWORD_LENGTH = "VLD1008";
	/*
	 *at least 1 lowercase alphabetical character
	 *at least 1 uppercase alphabetical character
	 *at least 1 numeric character
	 *at least one special character 
	 *must be eight characters or longer
	 */
	public static final String PASSWORD_STRENGTH="VLD1009";
	

}
