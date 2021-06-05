package org.serratec.backend.projeto06.services;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.entities.AutorEntity;
import org.serratec.backend.projeto06.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;

	public List<AutorEntity> getAll() {
		return autorRepository.findAll();
	}

	public AutorEntity create(AutorEntity entity) {
		return autorRepository.save(entity);
	}

	public AutorEntity getById(Long id) {
		Optional<AutorEntity> autor = autorRepository.findById(id);

		if (autor.isEmpty()) {
			System.out.println("Id não cadastrado");

			return null;
		}

		return autor.get();
	}

	public AutorEntity update(Long id, AutorEntity entity) {
		AutorEntity autor = this.getById(id);

		if (entity.getNome() != null) {
			autor.setNome(entity.getNome());
		}

		return autorRepository.save(autor);
	}

	public void delete(Long id) {
		autorRepository.deleteById(id);
	}
}
