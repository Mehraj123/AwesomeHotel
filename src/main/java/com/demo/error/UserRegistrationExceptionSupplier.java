package com.demo.error;

import java.util.function.Supplier;

/***
 * Non-instantiable Exception class for {@code UserRegistration}
 * 
 * @author Iti Gupta
 *
 */
public final class UserRegistrationExceptionSupplier {

	private UserRegistrationExceptionSupplier() {
	}

	public static final Supplier<CustomParameterizedException> USERNAME_NOT_UNIQUE = () -> new CustomParameterizedException(
			RegisteredException.USER_REGISTRATION_EXCEPTION.getException(),
			CustomExceptionCode.USERNAME_NOT_UNIQUE.getErrMsg(), CustomExceptionCode.USERNAME_NOT_UNIQUE.getErrCode());

	public static final Supplier<CustomParameterizedException> PHONE_NUMBER_NOT_UNIQUE = () -> new CustomParameterizedException(
			RegisteredException.USER_REGISTRATION_EXCEPTION.getException(),
			CustomExceptionCode.PHONE_NUMBER_NOT_UNIQUE.getErrMsg(),
			CustomExceptionCode.PHONE_NUMBER_NOT_UNIQUE.getErrCode());

	public static final Supplier<CustomParameterizedException> EMAIL_NOT_UNIQUE = () -> new CustomParameterizedException(
			RegisteredException.USER_REGISTRATION_EXCEPTION.getException(),
			CustomExceptionCode.EMAIL_NOT_UNIQUE.getErrMsg(), CustomExceptionCode.EMAIL_NOT_UNIQUE.getErrCode());

	public static final Supplier<CustomParameterizedException> USER_REGISTRATION_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.USER_REGISTRATION_EXCEPTION.getException(),
			CustomExceptionCode.USER_REGISTRATION_EXCEPTION.getErrMsg(),
			CustomExceptionCode.USER_REGISTRATION_EXCEPTION.getErrCode());

	public static final Supplier<CustomParameterizedException> USER_FETCHED_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.USER_FETCHED_EXCEPTION.getException(),
			CustomExceptionCode.USER_FETCHED_EXCEPTION.getErrMsg(),
			CustomExceptionCode.USER_FETCHED_EXCEPTION.getErrCode());
	
	public static final Supplier<CustomParameterizedException> USER_NOT_FOUND_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.USER_NOT_FOUND_EXCEPTION.getException(),
			CustomExceptionCode.USER_NOT_FOUND_EXCEPTION.getErrMsg(),
			CustomExceptionCode.USER_NOT_FOUND_EXCEPTION.getErrCode());




}
