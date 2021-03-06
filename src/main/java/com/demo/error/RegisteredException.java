package com.demo.error;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public enum RegisteredException {
	
	CONSTRAINT_VIOLATION_EXCEPTION("ConstraintViolationException", "Constraint Violation Exception Occurred"),
	METHOD_NOT_ALLOWED("HttpRequestMethodNotSupportedException", "Http Request Method Not Supported Exception Occurred"),
	UNKNOWN_EXCEPTION("Unknown Exception", "Unknown Exception Occurred"),
	UNAUTHORIZED_EXCEPTION("Unauthorized exception", "Unauthorized exception Occurred"),
	HTTP_BODY_EXCEPTION("HttpMessageNotReadableException","Http messgae body is not valid"),
	HOTEL_EXCEPTION("HotelException","Hotel exception"),
	USER_REGISTRATION_EXCEPTION("UserRegistrationException","User Registration Exception"),
	USER_FETCHED_EXCEPTION("UserFetchedException","Exception occurred while fetching the demo"),
	USER_NOT_FOUND_EXCEPTION("UserNotFoundException","User is not Registered"),
	LOGIN_NOT_SUCCESSFULL("LoginException","Exception occurred while login");

	private final String exception;
	private final String exceptionMessage;

	private RegisteredException(final String exception, String exceptionMessage) {
		this.exception = exception;
		this.exceptionMessage = exceptionMessage;
	}

	public String getException() {
		return exception;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}
}
