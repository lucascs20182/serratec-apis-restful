package org.com.serratec.backend.ProjetoCrud04.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.com.serratec.backend.ProjetoCrud04.config.MailConfig;
import org.com.serratec.backend.ProjetoCrud04.dto.AutorDTO;
import org.com.serratec.backend.ProjetoCrud04.entity.AutorEntity;
import org.com.serratec.backend.ProjetoCrud04.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

	@Autowired
	AutorRepository repository;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	MailConfig mailConfig;
	
	@Value("${body.mail}")
	String body;
	
	
	public AutorEntity getById(Integer id) {
		Optional<AutorEntity> autor = repository.findById(id);
		return autor.get();
	}
	
	public List<AutorEntity> getAll(){
		return repository.findAll();
	}
	
	public String create(AutorDTO dto) throws MessagingException {
		AutorEntity entity = new AutorEntity();
		entity.setNome(dto.getNome());
		AutorEntity autorSaved = repository.save(entity);
		addressService.create(dto.getCep(), autorSaved);
		return mailConfig.sendMail("lucascs20182@gmail.com", "teste", body);
	}

}
