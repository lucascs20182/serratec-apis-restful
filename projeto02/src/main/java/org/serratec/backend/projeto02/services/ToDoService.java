package org.serratec.backend.projeto02.services;

import java.util.List;

import org.serratec.backend.projeto02.models.ToDoModel;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	public List<ToDoModel> create() {
		return List.of(new ToDoModel(1, "Ir ao mercado", "Ir ao mercado comprar a janta"),
				new ToDoModel(2, "Reunião às 16hrs", "Reunião com fulano às 16hrs"));
	}
}
