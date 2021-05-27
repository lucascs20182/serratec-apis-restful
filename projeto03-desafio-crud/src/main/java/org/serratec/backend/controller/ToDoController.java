package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.model.ToDoModel;
import org.serratec.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoController {

	@Autowired
	ToDoService toDoService;
	
	@GetMapping
	public List<ToDoModel> getAll() {
		return toDoService.getAll();
	}

	@GetMapping("/{id}")
	public ToDoModel getOne(@PathVariable int id) {
		return toDoService.getOne(id);
	}

	@PostMapping("/create")
	public void create(@RequestBody ToDoModel toDoModel) {
		toDoService.create(toDoModel);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		toDoService.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody ToDoModel toDoModel) {
		toDoService.update(id, toDoModel);
	}

}