package com.demo.error;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public class CustomParameterizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String exception;
	private final String exceptionMessage;
	private final List<String> exceptionCodes = new ArrayList<>();

	public CustomParameterizedException(String exception, String exceptionMessage, String... params) {
		super(exception);
		this.exception = exception;
		this.exceptionMessage = exceptionMessage;
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				exceptionCodes.add(params[i]);
			}
		}
	}

	public CustomParameterizedException(String exception, String exceptionMessage, List<String> paramList) {
		super(exception);
		this.exception = exception;
		this.exceptionMessage = exceptionMessage;
		this.exceptionCodes.addAll(paramList);
	}

	public ParameterizedErrorVM getErrorVM() {
		return new ParameterizedErrorVM(exception, exceptionMessage, exceptionCodes);
	}
}
