package org.serratec.backend.projeto04.projeto04exceptions.controllers;

import java.util.List;

import org.serratec.backend.projeto04.projeto04exceptions.exceptions.BalanceNotEnoughToOperationException;
import org.serratec.backend.projeto04.projeto04exceptions.exceptions.ItemNotFoundException;
import org.serratec.backend.projeto04.projeto04exceptions.models.ContaModel;
import org.serratec.backend.projeto04.projeto04exceptions.models.OperacaoModel;
import org.serratec.backend.projeto04.projeto04exceptions.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conta")
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	@GetMapping
	public ResponseEntity<List<ContaModel>> listarTudo() {
		return ResponseEntity.ok().body(contaService.listarTudo());
	}
	
	@GetMapping("/{numero}")
	public ResponseEntity<ContaModel> listarUm(@PathVariable Integer numero) throws ItemNotFoundException {
		return ResponseEntity.ok().body(contaService.listarUm(numero));
	}
	
	@PostMapping
	public ResponseEntity<ContaModel> criar(@RequestBody ContaModel conta) {
		return ResponseEntity.ok().body(contaService.criar(conta));
	}
	
	@PutMapping("/atualizar/{numero}")
	public ResponseEntity<ContaModel> editar(@PathVariable Integer numero, @RequestBody ContaModel conta) throws ItemNotFoundException {
		return ResponseEntity.ok().body(contaService.atualizarConta(numero, conta));
	}
	
	@PutMapping("/atualizar/saldo/{numero}")
	public ResponseEntity<ContaModel> editarSaldo(@PathVariable Integer numero, @RequestBody OperacaoModel operacao) throws ItemNotFoundException, BalanceNotEnoughToOperationException {
		return ResponseEntity.ok().body(contaService.atualizarSaldo(numero, operacao));
	}
	
	@DeleteMapping("/{numero}")
	public ResponseEntity<String> deletar(@PathVariable Integer numero) {
		return ResponseEntity.ok().body(contaService.deletar(numero));
	}
}
