package org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.model.ToDoModel;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	public static List<ToDoModel> lista = new ArrayList<>();

	public void create(ToDoModel toDoModel) {
		lista.add(toDoModel);
	}

	public List<ToDoModel> getAll() {
		return lista;
	}

	public ToDoModel getOne(int id) {
		for (ToDoModel tdm : lista) {
			if (tdm.getId() == id) {
				return tdm;
			}
		}
		System.out.println("Não encontrado.");
		return null;
	}

	public void delete(int id) {

		for (ToDoModel tdm : lista) {
			if (tdm.getId() == id) {

				// Exclui na posição dentro da lista.
				lista.remove(lista.indexOf(tdm));
				return;
			}
		}
		System.out.println("Não encontrado.");
	}

	public void update(int id, ToDoModel outroTD) {

		for (ToDoModel tdm : lista) {
			if (tdm.getId() == id) {
				tdm.setDescricao(outroTD.getDescricao());
				tdm.setNome(outroTD.getNome());
				return;
			}
		}
		System.out.println("Não encontrado.");
	}

}