package com.student.data.exception;

import org.springframework.http.HttpStatus;

public class DataApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3615053310737041653L;

	private HttpStatus httpStatus;
	private String message;

	public DataApplicationException(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
