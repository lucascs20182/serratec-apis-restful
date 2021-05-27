package org.serratec.backend.projeto01.controllers;

import java.util.List;

import org.serratec.backend.projeto01.models.CalculadoraModel;
import org.serratec.backend.projeto01.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	@Autowired
	CalculadoraService service;

	@PostMapping("/calcular")
	public Integer calcular(@RequestBody CalculadoraModel calculadora) {
		return service.calcular(calculadora);
	}
	
	@PostMapping("/criar")
	public void criar(@RequestBody CalculadoraModel calculadora) {
		service.create(calculadora);
	}
	
	@GetMapping("/visualizar")
	public List<CalculadoraModel> subtrair(@RequestBody CalculadoraModel calculadora) {
		return service.getAll();
	}
	
	@GetMapping("/procurar/{numero1}")
	public CalculadoraModel procurar(@PathVariable Integer numero1) {
		return service.procurar(numero1);
	}
}
