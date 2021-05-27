package org.serratec.backend.model;

public class ToDoModel {

	private Integer id;
	private String nome;
	private String descricao;

	public ToDoModel(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public ToDoModel(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public ToDoModel() {
		
	}

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

}
