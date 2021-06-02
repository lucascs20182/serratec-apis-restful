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
	
	public List<CategoriaEntity> getAll(){
		return categoriaRepository.findAll();
	}
	
	public CategoriaEntity getOne(Long id) {
		Optional<CategoriaEntity> categoria= categoriaRepository.findById(id);
		return categoria.get();
	}
	
	public void adicionar(CategoriaEntity categoria) {
		categoriaRepository.save(categoria);
	}
	
	public void remover(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	public void atualizar(Long id, CategoriaEntity novosDadosCategoria) {
		CategoriaEntity categoria=this.getOne(id);
		if(novosDadosCategoria.getNome()!=null) {
			categoria.setNome(novosDadosCategoria.getNome());
		}
		categoriaRepository.save(categoria);
		
//		if(novosDadosLivro.getCategoria()!=null) {
//			livro.setCategoria(novosDadosLivro.getCategoria());
//		}
	}
}
