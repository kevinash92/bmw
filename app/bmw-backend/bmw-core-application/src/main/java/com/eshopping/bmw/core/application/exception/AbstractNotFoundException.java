package com.eshopping.bmw.core.application.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected AbstractNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	protected AbstractNotFoundException(final String message) {
		super(message);
	}
}
