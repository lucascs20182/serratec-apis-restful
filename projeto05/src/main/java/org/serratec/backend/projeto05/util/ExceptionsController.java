// o pacote util serve para adicionar classes que serão úteis para o projeto inteiro
// aqui ficam classes que manipulam data, que contram exceptions e coisas do tipo

package org.serratec.backend.projeto05.util;

import org.serratec.backend.projeto05.exceptions.ItemNotFoundException;
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
}
