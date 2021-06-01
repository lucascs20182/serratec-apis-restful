// onde fica a regra de negócio

package org.serratec.backend.projeto05.services;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto05.entities.LivroEntity;
import org.serratec.backend.projeto05.exceptions.ItemNotFoundException;
import org.serratec.backend.projeto05.mappers.LivroMapper;
import org.serratec.backend.projeto05.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	// a anotação autowired faz com que não seja preciso instanciar uma classe
	// além disso, toda classe que tem a mesma anotação, nesse exemplo @Service
	// têm o mesmo objeto se chamarem o @Autowired no repositório
	@Autowired
	LivroRepository repository;

	@Autowired
	LivroMapper mapper;

	public List<LivroEntity> getAll() {
		return repository.findAll();
	}
	
	public LivroEntity getById(Long id) throws ItemNotFoundException {
		Optional<LivroEntity> livro = repository.findById(id);
		
		if (livro.isEmpty()) {
			throw new ItemNotFoundException("Não existe livro com esse Id.");
		}
		
		return livro.get();
	}
	
	public void create(LivroEntity livro) {
		repository.save(livro);
	}
	
	public void update(Long id, LivroEntity novasInfosLivro) throws ItemNotFoundException {
		LivroEntity livro = getById(id);
		
		livro.setTitulo(novasInfosLivro.getTitulo());
		livro.setAutor(novasInfosLivro.getAutor());
		livro.setTipo(novasInfosLivro.getTipo());
		livro.setDataPublicacao(novasInfosLivro.getDataPublicacao());
		
		mapper.toDTO(repository.save(livro));
	}
	
	public void delete(Long id) throws ItemNotFoundException {
		getById(id);
		
		repository.deleteById(id);
	}
}
