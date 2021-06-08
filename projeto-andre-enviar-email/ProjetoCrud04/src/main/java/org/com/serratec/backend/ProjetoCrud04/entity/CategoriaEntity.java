package org.com.serratec.backend.ProjetoCrud04.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String descricao;

	@OneToMany(mappedBy = "categoria")
	private List<LivroEntity> livros;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<LivroEntity> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroEntity> livros) {
		this.livros = livros;
	}

}
