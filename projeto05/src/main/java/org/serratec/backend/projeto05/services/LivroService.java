package org.serratec.backend.projeto05.services;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto05.dtos.LivroDTO;
import org.serratec.backend.projeto05.entities.LivroEntity;
import org.serratec.backend.projeto05.mappers.LivroMapper;
import org.serratec.backend.projeto05.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository repository;

	@Autowired
	LivroMapper mapper;

	public List<LivroEntity> getAll() {
		return repository.findAll();
	}
	
	public LivroEntity getById(Long id) {
		Optional<LivroEntity> livro = repository.findById(id);
		
//		if (livro.isEmpty()) {
//			throw new ItemNotFoundException("Não existe livro com esse Id.");
//		}
		
		return livro.get();
	}
	
	public void create(LivroEntity livro) {
		repository.save(livro);
	}
	
	public void update(Long id, LivroEntity novasInfosLivro) {
		LivroEntity livro = getById(id);
		
		livro.setTitulo(novasInfosLivro.getTitulo());
		livro.setAutor(novasInfosLivro.getAutor());
		livro.setTipo(novasInfosLivro.getTipo());
		livro.setDataPublicacao(novasInfosLivro.getDataPublicacao());
		
		mapper.toDTO(repository.save(livro));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
