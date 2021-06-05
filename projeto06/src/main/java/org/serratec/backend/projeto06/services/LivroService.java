package org.serratec.backend.projeto06.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.entities.AutorEntity;
import org.serratec.backend.projeto06.entities.LivroEntity;
import org.serratec.backend.projeto06.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	AutorService autorService;

	public List<LivroEntity> getAll() {
		return livroRepository.findAll();
	}

	public LivroEntity create(LivroEntity entity) {
		List<AutorEntity> listaAutores = new ArrayList<AutorEntity>();

		for (AutorEntity autor : entity.getAutores()) {
			listaAutores.add(autorService.getById(autor.getId()));
		}

		entity.setAutores(listaAutores);

		entity.setCategoria(categoriaService.getById(entity.getCategoria().getId()));

		return livroRepository.save(entity);
	}

	public LivroEntity getById(Long id) {
		Optional<LivroEntity> livro = livroRepository.findById(id);

		if (livro.isEmpty()) {
			System.out.println("Id não cadastrado");

			return null;
		}

		return livro.get();
	}

	public LivroEntity update(Long id, LivroEntity entity) {
		LivroEntity livro = this.getById(id);

		if (entity.getNome() != null) {
			livro.setNome(entity.getNome());
		}

		if (entity.getAutores() != null) {
			List<AutorEntity> listaAutores = new ArrayList<AutorEntity>();

			for (AutorEntity autor : entity.getAutores()) {
				listaAutores.add(autorService.getById(autor.getId()));
			}

			livro.setAutores(listaAutores);
		}

		if (entity.getCategoria() != null) {
			livro.setCategoria(categoriaService.getById(entity.getCategoria().getId()));
		}

		return livroRepository.save(livro);
	}

	public void delete(Long id) {
		livroRepository.deleteById(id);
	}
}
