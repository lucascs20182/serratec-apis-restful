package org.serratec.backend.projeto01.models;

public class CalculadoraModel {
	private double n1, n2;

	public CalculadoraModel(double n1, double n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	public double getN1() {
		return n1;
	}

	public double getN2() {
		return n2;
	}
	
	public double somar() {
		return this.n1 + this.n2;
	}
	
	public double subtrair() {
		return this.n1 - this.n2;
	}
	
	public double multiplicar() {
		return this.n1 * this.n2;
	}
	
	public double dividir() {
		if(this.n2 == 0) {
			throw new ArithmeticException();
		}
		
		return this.n1 / this.n2;
	}
}
