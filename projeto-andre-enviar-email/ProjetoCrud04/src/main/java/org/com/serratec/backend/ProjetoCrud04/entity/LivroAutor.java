package org.com.serratec.backend.ProjetoCrud04.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity	
public class LivroAutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private LivroEntity livro;
	
	@ManyToOne
	private AutorEntity autor;
}
