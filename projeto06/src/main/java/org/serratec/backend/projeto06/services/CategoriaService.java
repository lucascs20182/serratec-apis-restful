package org.serratec.backend.projeto06.services;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.entities.CategoriaEntity;
import org.serratec.backend.projeto06.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public List<CategoriaEntity> getAll() {
		return categoriaRepository.findAll();
	}

	public CategoriaEntity create(CategoriaEntity entity) {
		return categoriaRepository.save(entity);
	}

	public CategoriaEntity getById(Long id) {
		Optional<CategoriaEntity> categoria = categoriaRepository.findById(id);

		if (categoria.isEmpty()) {
			System.out.println("Id não cadastrado");

			return null;
		}

		return categoria.get();
	}

	public CategoriaEntity update(Long id, CategoriaEntity entity) {
		CategoriaEntity categoria = this.getById(id);

		if (entity.getNome() != null) {
			categoria.setNome(entity.getNome());
		}

		if (entity.getDescricao() != null) {
			categoria.setDescricao(entity.getDescricao());
		}

		return categoriaRepository.save(categoria);
	}

	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}
}
