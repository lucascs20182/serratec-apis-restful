// recebe as requisições e controla o fluxo 
// faz a conexão com o front (ou um cliente externo, tipo o postman)
// gerencia o sistema de rotas (recursos)

package org.serratec.backend.projeto05.controllers;

import java.util.List;

import org.serratec.backend.projeto05.entities.LivroEntity;
import org.serratec.backend.projeto05.exceptions.ItemNotFoundException;
import org.serratec.backend.projeto05.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que a classe é um rest controller pro spring boot
@RequestMapping("/livro") // endpoint
public class LivroController {
	//endpoint: URL onde seu serviço pode ser acessado por uma aplicação cliente.
	
	@Autowired
	LivroService service;
	
	@GetMapping //o endpoint vai ficar http://localhost:8080/livro
	public ResponseEntity<List<LivroEntity>> findAll() {
		return ResponseEntity.ok().body(service.getAll());
	}
	
	@GetMapping("/{id}") //o endpoint vai ficar http://localhost:8080/livro/1
	public ResponseEntity<LivroEntity> findById(@PathVariable Long id) throws ItemNotFoundException {
		return ResponseEntity.ok().body(service.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody LivroEntity livro) {
		service.create(livro);
		
		return new ResponseEntity<String>("Criado com sucesso", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody LivroEntity livro) throws ItemNotFoundException {
		service.update(id, livro);
		
		ResponseEntity.ok();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws ItemNotFoundException {
		service.delete(id);
		
		return ResponseEntity.ok().body("Deletado com sucesso");
	}
}
