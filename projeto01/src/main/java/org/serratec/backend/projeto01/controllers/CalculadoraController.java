package org.serratec.backend.projeto01.controllers;

import org.serratec.backend.projeto01.models.CalculadoraModel;
import org.serratec.backend.projeto01.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	@Autowired
	CalculadoraService service;

	@GetMapping("/soma")
	public Integer somar(@RequestBody CalculadoraModel calculadora) {
		return service.somar(calculadora);
	}
	
	@GetMapping("/subtracao")
	public Integer subtrair(@RequestBody CalculadoraModel calculadora) {
		return service.subtrair(calculadora);
	}
	
	@GetMapping("/multiplicacao")
	public Integer multiplicar(@RequestBody CalculadoraModel calculadora) {
		return service.multiplicar(calculadora);
	}
	
	@GetMapping("/divisao")
	public Integer dividir(@RequestBody CalculadoraModel calculadora) {
		return service.dividir(calculadora);
	}
}
