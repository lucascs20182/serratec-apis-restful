package org.serratec.backend.projeto05.controllers;

import java.util.List;

import org.serratec.backend.projeto05.dtos.LivroDTO;
import org.serratec.backend.projeto05.entities.LivroEntity;
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

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService service;
	
	@GetMapping
	public ResponseEntity<List<LivroEntity>> findAll() {
		return ResponseEntity.ok().body(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroEntity> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody LivroEntity livro) {
		service.create(livro);
		
		return new ResponseEntity<String>("Criado com sucesso", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody LivroEntity livro) {
		service.update(id, livro);
		
		ResponseEntity.ok();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.ok().body("Deletado com sucesso");
	}
}
