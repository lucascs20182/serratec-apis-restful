package org.serratec.backend.projeto04.projeto04exceptions.exceptions;

public class BalanceNotEnoughToOperationException extends Exception {

	private static final long serialVersionUID = 1L;

	public BalanceNotEnoughToOperationException() {
		super();
	}

	public BalanceNotEnoughToOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BalanceNotEnoughToOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public BalanceNotEnoughToOperationException(String message) {
		super(message);
	}

	public BalanceNotEnoughToOperationException(Throwable cause) {
		super(cause);
	}
}
