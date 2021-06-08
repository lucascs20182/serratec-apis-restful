package org.com.serratec.backend.ProjetoCrud04.service;

import java.util.List;
import java.util.Optional;

import org.com.serratec.backend.ProjetoCrud04.entity.AutorEntity;
import org.com.serratec.backend.ProjetoCrud04.entity.CategoriaEntity;
import org.com.serratec.backend.ProjetoCrud04.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	
	public List<CategoriaEntity> getAll(){
		return repository.findAll();
	}
	
	public CategoriaEntity create(CategoriaEntity entity) {
		return repository.save(entity);
	}
	
	public CategoriaEntity getById(Integer id) {
		Optional<CategoriaEntity> categoria = repository.findById(id);
		if (categoria.isEmpty()) {
			System.out.println("Id não cadastrado");
			return null;
		}
		return categoria.get();
	}
	
	public CategoriaEntity update(Integer id, CategoriaEntity entity) {
		CategoriaEntity categoria = getById(id);
		if(entity.getNome() !=  null) {
			categoria.setNome(entity.getNome());
		}
		if(entity.getDescricao() != null) {
			categoria.setDescricao(entity.getDescricao());
		}
		return repository.save(categoria);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
