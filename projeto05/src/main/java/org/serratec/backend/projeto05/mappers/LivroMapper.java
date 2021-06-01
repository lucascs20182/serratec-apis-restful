package org.serratec.backend.projeto05.mappers;

import org.serratec.backend.projeto05.dtos.LivroDTO;
import org.serratec.backend.projeto05.entities.LivroEntity;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

	public LivroEntity toEntity(LivroDTO dto) {
		LivroEntity entity = new LivroEntity();

		entity.setTitulo(dto.getTipo());
		entity.setAutor(dto.getAutor());
		entity.setTipo(dto.getTipo());
		entity.setDataPublicacao(dto.getDataPublicacao());

		return entity;
	}

	public LivroDTO toDTO(LivroEntity entity) {
		LivroDTO dto = new LivroDTO();

		dto.setTitulo(entity.getTipo());
		dto.setAutor(entity.getAutor());
		dto.setTipo(entity.getTipo());
		dto.setDataPublicacao(entity.getDataPublicacao());

		return dto;
	}
}
