// serve para evitar que um erro da linguagem ou framework (muito técnico)
// seja enviado a quem está consumindo a api
// você intercepta o erro e passa um erro mais simpático ao usuário

package org.serratec.backend.projeto05.exceptions;

public class ItemNotFoundException extends Exception {

	public ItemNotFoundException() {
		super();
	}

	public ItemNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemNotFoundException(String message) {
		super(message);
	}

	public ItemNotFoundException(Throwable cause) {
		super(cause);
	}
}
