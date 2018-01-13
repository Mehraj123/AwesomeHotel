package com.ah.successcode;

/**
 * @author Mehraj Malik
 * @version 1.0
 *
 */
public enum HotelSuccessCode {

	HOTEL_CREATED("SCS001", "Hotel created successfully"),
	HOTEL_UPDATED("SCS002", "Hotel updated successfully"),
	HOTEL_DELETED("SCS003", "Hotel deleted successfully"),
	HOTEL_FETCHED("SCS004", "Hotel fetched successfully");
	

	private final String code;
	private final String message;
	
	
	private HotelSuccessCode(String code, String message) {
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
