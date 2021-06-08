package org.com.serratec.backend.ProjetoCrud04.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Livro")
public class LivroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	@ManyToOne
//	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private CategoriaEntity categoria;
	
	@OneToMany(mappedBy = "livro")
//	@JoinTable(name = "livro_autor",joinColumns = 
//	@JoinColumn(name = "livro", referencedColumnName = "id"),
//	inverseJoinColumns = 
//	@JoinColumn(name = "autor", referencedColumnName = "id"))
	private List<LivroAutor> autores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public List<LivroAutor> getAutores() {
		return autores;
	}

	public void setAutores(List<LivroAutor> autores) {
		this.autores = autores;
	}


}
