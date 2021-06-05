package org.serratec.backend.projeto06.controllers;

import java.util.List;

import org.serratec.backend.projeto06.entities.AutorEntity;
import org.serratec.backend.projeto06.services.AutorService;
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
@RequestMapping("/autor")
public class AutorController {
	@Autowired
	AutorService service;

	@GetMapping
	public ResponseEntity<List<AutorEntity>> getAll() {
		return new ResponseEntity<List<AutorEntity>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AutorEntity> getById(@PathVariable Long id) {
		return new ResponseEntity<AutorEntity>(service.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody AutorEntity autor) {
		service.create(autor);

		return new ResponseEntity<String>("Autor cadastrado com sucesso", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AutorEntity autor) {
		service.update(id, autor);

		return new ResponseEntity<String>("Autor editado com sucesso", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Autor deletado com sucesso", HttpStatus.OK);
	}
}
