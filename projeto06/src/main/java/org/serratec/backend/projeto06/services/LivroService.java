package org.serratec.backend.projeto06.services;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.entities.CategoriaEntity;
import org.serratec.backend.projeto06.entities.LivroEntity;
import org.serratec.backend.projeto06.repositories.CategoriaRepository;
import org.serratec.backend.projeto06.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<LivroEntity> getAll(){
		return livroRepository.findAll();
	}
	
	public LivroEntity getOne(Long id) {
		Optional<LivroEntity> livro= livroRepository.findById(id);
		return livro.get();
	}
	
	public void adicionar(LivroEntity livro) {
		Long idCategoria =livro.getCategoria().getId();
		Optional<CategoriaEntity> categoria= categoriaRepository.findById(idCategoria);
		livro.setCategoria(categoria.get());
	    livroRepository.save(livro);
	}
	
	public void remover(Long id) {
		livroRepository.deleteById(id);
	}
	
	public void atualizar(Long id, LivroEntity novosDadosLivro) {
		LivroEntity livro=this.getOne(id);
		Long idCategoria =novosDadosLivro.getCategoria().getId();
		if (idCategoria!= null) {
			Optional<CategoriaEntity> categoria= categoriaRepository.findById(idCategoria);
			livro.setCategoria(categoria.get());
		}
		if(novosDadosLivro.getNome()!=null) {
			livro.setNome(novosDadosLivro.getNome());
		}
		livroRepository.save(livro);
		
//		if(novosDadosLivro.getCategoria()!=null) {
//			livro.setCategoria(novosDadosLivro.getCategoria());
//		}
    
	}
}
