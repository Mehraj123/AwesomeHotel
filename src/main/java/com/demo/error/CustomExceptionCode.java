package com.demo.error;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public enum CustomExceptionCode {

	HOTEL_FETCH_EXCEPTION("ERR0001","Exception occured while fetching hotel"),
	HOTEL_SAVE_EXCEPTION("ERR0002","Exception occured while saving hotel"),
	HOTEL_UPDATE_EXCEPTION("ERR0003","Exception occured while updating hotel"),
	HOTEL_DELETE_EXCEPTION("ERR0004","Exception occured while deleting hotel"),
	NO_HOTEL_EXIST_WITH_ID_EXCEPTION("ERR0005","No hotel exist with provided Id"),
	HOTELNAME_NOT_UNIQUE_EXCEPTION("ERR0006","Hotel name must be unique."),
	SIZE_CANNOT_BE_NEGATIVE("ERR0007","Size cannot be negative"),
	USERNAME_NOT_UNIQUE("ERR0008", "User name is not Unique"),
	EMAIL_NOT_UNIQUE("ERR0009", "Email is not Unique"),
	PHONE_NUMBER_NOT_UNIQUE("ERR0010", "Phone number is not Unique"),
	USER_REGISTRATION_EXCEPTION("ERR0011", "Exception occurred while registring a user"),
	USER_FETCHED_EXCEPTION("ERR0012","Exception occurred while fetching the user"),
	USER_NOT_FOUND_EXCEPTION("ERR0013","Username not found"),
	LOGIN_EXCEPTION("ERR0014","Exception occurred while login");

	
	private final String errCode;
	private final String errMsg;

	private CustomExceptionCode(final String errCode, final String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	@Override
	public String toString() {
		return errCode + " : " + errMsg;
	}
}
