package org.serratec.backend.projeto06.controllers;

import java.util.List;

import org.serratec.backend.projeto06.entities.CategoriaEntity;
import org.serratec.backend.projeto06.services.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService service;

	@GetMapping
	public ResponseEntity<List<CategoriaEntity>> getAll() {
		return new ResponseEntity<List<CategoriaEntity>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaEntity> getById(@PathVariable Long id) {
		return new ResponseEntity<CategoriaEntity>(service.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody CategoriaEntity categoria) {
		service.create(categoria);

		return new ResponseEntity<String>("Categoria cadastrada com sucesso", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CategoriaEntity categoria) {
		service.update(id, categoria);

		return new ResponseEntity<String>("Categoria editada com sucesso", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Categoria deletada com sucesso", HttpStatus.OK);
	}
}
