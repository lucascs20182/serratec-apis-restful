package org.serratec.backend.projeto01.controllers;

import org.serratec.backend.projeto01.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	@Autowired
	CalculadoraService service;

	@GetMapping("/soma")
	public String somar(@RequestParam double numero1, double numero2) {
		return service.somar(numero1, numero2);
	}
	
	@GetMapping("/subtracao")
	public String subtrair(@RequestParam double numero1, double numero2) {
		return service.subtrair(numero1, numero2);
	}
	
	@GetMapping("/multiplicacao")
	public String multiplicar(@RequestParam double numero1, double numero2) {
		return service.multiplicar(numero1, numero2);
	}
	
	@GetMapping("/divisao")
	public String dividir(@RequestParam double numero1, double numero2) {
		return service.dividir(numero1, numero2);
	}
}
