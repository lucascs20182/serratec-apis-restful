package org.serratec.backend.projeto04.projeto04exceptions.util;

import org.serratec.backend.projeto04.projeto04exceptions.exceptions.BalanceNotEnoughToOperationException;
import org.serratec.backend.projeto04.projeto04exceptions.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException exception) {
		return ResponseEntity.notFound()
				.header("x-erro-msg", exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(BalanceNotEnoughToOperationException.class)
	public ResponseEntity<String> handleBalanceNotEnoughToOperationException(BalanceNotEnoughToOperationException exception) {
		return ResponseEntity.notFound()
				.header("x-erro-msg", exception.getMessage())
				.build();
	}
}
