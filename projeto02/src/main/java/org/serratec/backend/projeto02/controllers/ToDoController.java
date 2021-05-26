package org.serratec.backend.projeto02.controllers;

import java.util.List;

import org.serratec.backend.projeto02.models.ToDoModel;
import org.serratec.backend.projeto02.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoController {
	@Autowired // injeção de dependências; substitui o new
	ToDoService service;

	@GetMapping
	public List<ToDoModel> toDo() {
		return service.create();
	}
}
