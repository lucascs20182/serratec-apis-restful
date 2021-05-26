package org.serratec.backend.projeto01.controllers;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	private final Locale BRASIL = new Locale("pt", "BR");
	
	@GetMapping("/soma")
	public String somar(@RequestParam double numero1, double numero2) {
		return String.format(BRASIL, "%.2f", numero1 + numero2);
	}
	
	@GetMapping("/subtracao")
	public String subtrair(@RequestParam double numero1, double numero2) {
		return String.format(BRASIL, "%.2f", numero1 - numero2);
	}
	
	@GetMapping("/multiplicacao")
	public String multiplicar(@RequestParam double numero1, double numero2) {
		return String.format(BRASIL, "%.2f", numero1 * numero2);
	}
	
	@GetMapping("/divisao")
	public String dividir(@RequestParam double numero1, double numero2) {
		return String.format(BRASIL, "%.2f", numero1 / numero2);
	}
}
