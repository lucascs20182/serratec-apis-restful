// seleciona só os atributos da entidade LivroEntity
// que desejamos passar para o cliente
// nesse caso, decidimos retirar o id

package org.serratec.backend.projeto05.dtos;

import java.util.Date;

public class LivroDTO {
	private String titulo;
	private String tipo;
	private String autor;
	private Date dataPublicacao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
