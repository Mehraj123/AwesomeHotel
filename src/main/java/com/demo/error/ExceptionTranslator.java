package com.demo.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionTranslator {

	private static final Logger log = LoggerFactory.getLogger(ExceptionTranslator.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ParameterizedErrorVM processValidationError(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<String> errorCodeList = new ArrayList<>();
		for (FieldError fieldError : fieldErrors) {
			errorCodeList.add(fieldError.getDefaultMessage());
		}
		return new ParameterizedErrorVM(RegisteredException.CONSTRAINT_VIOLATION_EXCEPTION.getException(),
				RegisteredException.CONSTRAINT_VIOLATION_EXCEPTION.getExceptionMessage(), errorCodeList);
	}

	@ExceptionHandler(CustomParameterizedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ParameterizedErrorVM processParameterizedValidationError(CustomParameterizedException ex) {
		log.error("Custom Exception cought :- ", ex);
		return ex.getErrorVM();
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ParameterizedErrorVM processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
		log.error("-- HttpRequestMethodNotSupportedException :-  ", exception);
		return new ParameterizedErrorVM(RegisteredException.METHOD_NOT_ALLOWED.getException(),
				RegisteredException.METHOD_NOT_ALLOWED.getExceptionMessage(), Collections.emptyList());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ParameterizedErrorVM processHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		log.error("-- Request Body not readable exception :-  ", exception);
		return new ParameterizedErrorVM(RegisteredException.HTTP_BODY_EXCEPTION.getException(),
				RegisteredException.HTTP_BODY_EXCEPTION.getExceptionMessage(), Collections.emptyList());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ParameterizedErrorVM processException(Exception ex) {
		log.error("----Unknown Exception :- ", ex);
		return new ParameterizedErrorVM(RegisteredException.UNKNOWN_EXCEPTION.getException(),
				RegisteredException.UNKNOWN_EXCEPTION.getExceptionMessage(), Collections.emptyList());
	}
}