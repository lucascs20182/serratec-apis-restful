package org.serratec.backend.projeto01.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto01.models.CalculadoraModel;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	List<CalculadoraModel> listaCalculos = new ArrayList<CalculadoraModel>();

	public Integer calcular(CalculadoraModel calculadora) {
		if (calculadora.getOperador() != null) {
			switch (calculadora.getOperador()) {
			case "+":
				return calculadora.getNumero1() + calculadora.getNumero2();
			case "-":
				return calculadora.getNumero1() - calculadora.getNumero2();
			case "*":
				return calculadora.getNumero1() * calculadora.getNumero2();
			case "/":
				try {
					return calculadora.getNumero1() / calculadora.getNumero2();
				} catch (ArithmeticException e) {
					System.out.println("Dividir por zero é indefinido tendendo a infinito");
					return null;
				}
			default:
				System.out.println("Operador invalido para esse endpoint!");
				return null;
			}
		}

		System.out.println("Operador invalido para esse endpoint!");
		return null;
	}

	public void create(CalculadoraModel calculo) {
		this.listaCalculos.add(calculo);
	}

	public List<CalculadoraModel> getAll() {
		return this.listaCalculos;
	}

	public CalculadoraModel procurar(Integer n1) {
		for (CalculadoraModel calculadora : listaCalculos) {
			if (calculadora.getNumero1() == n1) {
				return calculadora;
			}
		}
		
		System.out.println("Numero não encontrado");
		return null;
	}
}
