package com.nextneo.system.currency.exception;

import org.springframework.validation.Errors;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private Errors errors;
	
	public BusinessException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}
	
	public BusinessException(String message, Throwable cause, Errors errors) {
		super(message, cause);
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	
}
