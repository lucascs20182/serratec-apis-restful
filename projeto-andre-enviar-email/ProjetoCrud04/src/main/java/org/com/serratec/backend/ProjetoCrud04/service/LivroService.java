//package org.com.serratec.backend.ProjetoCrud04.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.com.serratec.backend.ProjetoCrud04.entity.AutorEntity;
//import org.com.serratec.backend.ProjetoCrud04.entity.LivroEntity;
//import org.com.serratec.backend.ProjetoCrud04.repository.LivroRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LivroService {
//
//	@Autowired
//	LivroRepository repository;
//
//	@Autowired
//	CategoriaService categoriaService;
//
//	@Autowired
//	AutorService autorService;
//
//	public List<LivroEntity> getAll() {
//		return repository.findAll();
//	}
//
//	public LivroEntity create(LivroEntity entity) {
//		entity.setCategoria(categoriaService.getById(entity.getCategoria().getId()));
//		List<AutorEntity> listaAutores = new ArrayList<AutorEntity>();
//		for (AutorEntity autor : entity.getAutores()) {
//			listaAutores.add(autorService.getById(autor.getId()));
//		}
//		entity.setAutores(listaAutores);
//		return repository.save(entity);
//	}
//
//	public LivroEntity getById(Integer id) {
//		Optional<LivroEntity> livro = repository.findById(id);
//		if (livro.isEmpty()) {
//			System.out.println("Id não cadastrado");
//			return null;
//		}
//		return livro.get();
//	}
//
//	public LivroEntity update(Integer id, LivroEntity entity) {
//		LivroEntity livro = getById(id);
//		if (entity.getName() != null) {
//			livro.setName(entity.getName());
//		}
//		if (entity.getCategoria() != null) {
//			// livro.setCategoria(entity.getCategoria());
//			livro.setCategoria(categoriaService.getById(entity.getCategoria().getId()));
//		}
//		if (entity.getAutores() != null) {
//			List<AutorEntity> listaAutores = new ArrayList<AutorEntity>();
//			for (AutorEntity autor : entity.getAutores()) {
//				listaAutores.add(autorService.getById(autor.getId()));
//			}
//			livro.setAutores(listaAutores);
//		}
//		return repository.save(livro);
//	}
//	
//	public void delete(Integer id) {
//		repository.deleteById(id);
//	}
//}
