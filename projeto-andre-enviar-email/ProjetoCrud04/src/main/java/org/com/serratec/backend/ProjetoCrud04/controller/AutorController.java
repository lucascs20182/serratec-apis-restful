package org.com.serratec.backend.ProjetoCrud04.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.com.serratec.backend.ProjetoCrud04.dto.AddressDTO;
import org.com.serratec.backend.ProjetoCrud04.dto.AutorDTO;
import org.com.serratec.backend.ProjetoCrud04.entity.AddressEntity;
import org.com.serratec.backend.ProjetoCrud04.entity.AutorEntity;
import org.com.serratec.backend.ProjetoCrud04.service.AddressService;
import org.com.serratec.backend.ProjetoCrud04.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	AutorService autor;
	
	@Autowired
	AddressService address;
	
	@GetMapping
	public List<AutorEntity> findAllAutor(){
		return autor.getAll();
	}
	
	@GetMapping("/address")
	public List<AddressEntity> findAllAddress(){
		return address.getAll();
	}
	
	@PostMapping
	public String create(@RequestBody AutorDTO dto) throws MessagingException {
		return autor.create(dto);
	}
	
	@PostMapping("/outroaddress")
	public AddressEntity create2(@RequestBody AddressDTO dto) {
		return address.addNewAddress(dto);
	}

}
