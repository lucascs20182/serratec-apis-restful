package org.serratec.backend.projeto01.services;

import org.serratec.backend.projeto01.models.CalculadoraModel;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
	public Integer somar(CalculadoraModel calculadora) {
		return calculadora.getNumero1() + calculadora.getNumero2();
	}
	
	public Integer subtrair(CalculadoraModel calculadora) {
		return calculadora.getNumero1() - calculadora.getNumero2();
	}
	
	public Integer multiplicar(CalculadoraModel calculadora) {
		return calculadora.getNumero1() * calculadora.getNumero2();
	}
	
	public Integer dividir(CalculadoraModel calculadora) {
		try {
			return calculadora.getNumero1() / calculadora.getNumero2();
		} catch(ArithmeticException e) {
//	         return "dividir por zero é indefinido tendendo a infinito";
	         return null;
		}
	}
}
