package com.demo.error;

import java.util.function.Supplier;

/***
 * Exceptio Supplier class for Login
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public final class LoginExceptionSupplier {

	private LoginExceptionSupplier() {
	}

	public static final Supplier<CustomParameterizedException> LOGIN_NOT_SUCCESSFULL = () -> new CustomParameterizedException(
			RegisteredException.LOGIN_NOT_SUCCESSFULL.getException(), CustomExceptionCode.LOGIN_EXCEPTION.getErrMsg(),
			CustomExceptionCode.LOGIN_EXCEPTION.getErrCode());

    public static final Supplier<CustomParameterizedException> TOKEN_EXPIRED = () -> new CustomParameterizedException(
            RegisteredException.LOGIN_NOT_SUCCESSFULL.getException(), CustomExceptionCode.TOKEN_EXPIRED.getErrMsg(),
            CustomExceptionCode.TOKEN_EXPIRED.getErrCode());

    public static final Supplier<CustomParameterizedException> AUTHENTICATION_FAILED_EXCEPTION = () -> new CustomParameterizedException(
            RegisteredException.AUTHENTICATION_FAILED.getException(),
            CustomExceptionCode.AUTHENTICATION_FAILED.getErrMsg(),
            CustomExceptionCode.AUTHENTICATION_FAILED.getErrCode());

}
