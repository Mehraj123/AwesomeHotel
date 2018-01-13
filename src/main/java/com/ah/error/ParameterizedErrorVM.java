package com.ah.error;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public class ParameterizedErrorVM implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String exception;
	private final String exceptionMessage;
	private final List<String> errorCodeList;
	private final boolean success;

	public ParameterizedErrorVM(String exception, String message, List<String> errorCodeList) {
		this.success = false;
		this.exception = exception;
		this.exceptionMessage = message;
		this.errorCodeList = errorCodeList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getException() {
		return exception;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public List<String> getErrorCodeList() {
		return errorCodeList;
	}

	public boolean isSuccess() {
		return success;
	}

}
