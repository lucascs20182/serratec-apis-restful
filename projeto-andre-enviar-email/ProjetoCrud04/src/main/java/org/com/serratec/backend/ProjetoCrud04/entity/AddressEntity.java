package org.com.serratec.backend.ProjetoCrud04.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cep;

	private String cidade;

	@ManyToOne
	private AutorEntity autor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public AutorEntity getAutor() {
		return autor;
	}

	public void setAutor(AutorEntity autor) {
		this.autor = autor;
	}
	
	
}
