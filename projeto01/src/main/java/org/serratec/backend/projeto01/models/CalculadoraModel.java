package org.serratec.backend.projeto01.models;

public class CalculadoraModel {
	private Integer numero1;
	private Integer numero2;
	
	public CalculadoraModel(Integer numero1, Integer numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}

	public Integer getNumero1() {
		return numero1;
	}

	public Integer getNumero2() {
		return numero2;
	}
}
