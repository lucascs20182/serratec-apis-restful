package org.serratec.backend.projeto04.projeto04exceptions.models;

import org.serratec.backend.projeto04.projeto04exceptions.enums.TipoOperacao;

public class OperacaoModel {
	private TipoOperacao tipo;
	private double valor;

	public OperacaoModel(TipoOperacao tipo, double valor) {
		this.tipo = tipo;
		this.valor = valor;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
