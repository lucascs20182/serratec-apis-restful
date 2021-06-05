package org.serratec.backend.projeto06.controllers;

import java.util.List;

import org.serratec.backend.projeto06.entities.LivroEntity;
import org.serratec.backend.projeto06.services.LivroService;
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
	public ResponseEntity<List<LivroEntity>> getAll() {
		return new ResponseEntity<List<LivroEntity>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroEntity> getById(@PathVariable Long id) {
		return new ResponseEntity<LivroEntity>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody LivroEntity livro) {
		service.create(livro);
		
		return new ResponseEntity<String>("Livro cadastrado com sucesso", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody LivroEntity livro) {
		service.update(id, livro);
		
		return new ResponseEntity<String>("Livro editado com sucesso", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<String>("Livro deletado com sucesso", HttpStatus.OK);
	}
}
