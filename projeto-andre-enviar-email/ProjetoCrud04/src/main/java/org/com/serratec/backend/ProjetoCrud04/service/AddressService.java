package org.com.serratec.backend.ProjetoCrud04.service;

import java.util.List;

import org.com.serratec.backend.ProjetoCrud04.dto.AddressDTO;
import org.com.serratec.backend.ProjetoCrud04.dto.ViaCepDTO;
import org.com.serratec.backend.ProjetoCrud04.entity.AddressEntity;
import org.com.serratec.backend.ProjetoCrud04.entity.AutorEntity;
import org.com.serratec.backend.ProjetoCrud04.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

	@Autowired
	AddressRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AutorService autorservice;
	
	@Value("${address.baseUrl}")
	String baseUrl;

	public List<AddressEntity> getAll() {
		return repository.findAll();
	}

	public AddressEntity create(String cep, AutorEntity autor) {
		ViaCepDTO viaCep = restTemplate.getForObject(baseUrl + cep + "/json", ViaCepDTO.class);
		AddressEntity address = new AddressEntity();
		address.setAutor(autor);
		address.setCep(viaCep.getCep());
		address.setCidade(viaCep.getLocalidade());
		return repository.save(address);
	}
	
	public AddressEntity addNewAddress(AddressDTO dto) {
		ViaCepDTO viaCep = restTemplate.getForObject(baseUrl + dto.getCep() + "/json", ViaCepDTO.class);
		AddressEntity address = new AddressEntity();
		address.setAutor(autorservice.getById(dto.getAutorId()));
		address.setCep(viaCep.getCep());
		address.setCidade(viaCep.getLocalidade());
		return repository.save(address);
	}

}
