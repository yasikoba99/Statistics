package com.pinokiwo.statistics;

public class InvalidHistogramException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 7031261976045247219L;

	public InvalidHistogramException() {
	}

	public InvalidHistogramException(String message) {
		super(message);
	}

	public InvalidHistogramException(Throwable cause) {
		super(cause);
	}

	public InvalidHistogramException(String message, Throwable cause) {
		super(message, cause);
	}

}
