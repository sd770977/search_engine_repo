package com.nsdl.exception;

public class SearchTextCannotBeNullOrEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SearchTextCannotBeNullOrEmptyException() {
		super();
	}

	public SearchTextCannotBeNullOrEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SearchTextCannotBeNullOrEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public SearchTextCannotBeNullOrEmptyException(String message) {
		super(message);
	}

	public SearchTextCannotBeNullOrEmptyException(Throwable cause) {
		super(cause);
	}

}
