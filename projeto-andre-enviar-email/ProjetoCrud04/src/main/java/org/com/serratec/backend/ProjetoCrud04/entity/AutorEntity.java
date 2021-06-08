package org.com.serratec.backend.ProjetoCrud04.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Autor")
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

//	@ManyToMany(mappedBy = "autores")
//	private List<LivroEntity> livros;

	@JsonIgnore
	@OneToMany(mappedBy = "autor")
	private List<AddressEntity> enderecos;

	@OneToMany(mappedBy = "autor")
	private List<LivroAutor> livros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LivroAutor> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroAutor> livros) {
		this.livros = livros;
	}

	public List<AddressEntity> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<AddressEntity> enderecos) {
		this.enderecos = enderecos;
	}

}
