package org.serratec.backend.projeto01.services;

import java.util.Locale;

import org.serratec.backend.projeto01.models.CalculadoraModel;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
	private final Locale BRASIL = new Locale("pt", "BR");
	
	public String somar(double n1, double n2) {
		return String.format(BRASIL, "%.2f", new CalculadoraModel(n1, n2).somar());
	}
	
	public String subtrair(double n1, double n2) {
		return String.format(BRASIL, "%.2f", new CalculadoraModel(n1, n2).subtrair());
	}
	
	public String multiplicar(double n1, double n2) {
		return String.format(BRASIL, "%.2f", new CalculadoraModel(n1, n2).multiplicar());
	}
	
	public String dividir(double n1, double n2) {
		try {
			return String.format(BRASIL, "%.2f", new CalculadoraModel(n1, n2).dividir());
		} catch(ArithmeticException e) {
	         return "dividir por zero é indefinido tendendo a infinito";
		}
	}
}
