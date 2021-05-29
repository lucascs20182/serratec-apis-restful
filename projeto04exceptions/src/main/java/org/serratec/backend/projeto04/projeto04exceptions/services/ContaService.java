package org.serratec.backend.projeto04.projeto04exceptions.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto04.projeto04exceptions.enums.TipoOperacao;
import org.serratec.backend.projeto04.projeto04exceptions.exceptions.BalanceNotEnoughToOperationException;
import org.serratec.backend.projeto04.projeto04exceptions.exceptions.ItemNotFoundException;
import org.serratec.backend.projeto04.projeto04exceptions.models.ContaModel;
import org.serratec.backend.projeto04.projeto04exceptions.models.OperacaoModel;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
	private static final List<ContaModel> listaContas = new ArrayList<ContaModel>();
	
	public List<ContaModel> listarTudo() {
		return ContaService.listaContas;
	}
	
	public ContaModel listarUm(Integer numero) throws ItemNotFoundException {
		for (ContaModel conta : listaContas) {
			if (conta.getNumero().compareTo(numero) == 0) {
				return conta;
			}
		}
		
		throw new ItemNotFoundException("Não foi possivel encontrar esse número: " + numero);
	}
	
	public ContaModel criar(ContaModel conta) {
		listaContas.add(conta);
		
		return conta;
	}
	
	public ContaModel atualizarConta(Integer numero, ContaModel novosDadosConta) throws ItemNotFoundException {
		for (ContaModel conta : listaContas) {
			if (conta.getNumero().compareTo(numero) == 0) {
				conta.setTitular(novosDadosConta.getTitular());
				conta.setNumero(novosDadosConta.getNumero());
				
				return conta;
			}
		}
		
		throw new ItemNotFoundException("Não foi possivel encontrar esse número: " + numero);
	}
	
	public ContaModel atualizarSaldo(Integer numero, OperacaoModel operacao) throws ItemNotFoundException, BalanceNotEnoughToOperationException {
		for (ContaModel conta : listaContas) {
			if (conta.getNumero().compareTo(numero) == 0) {
				
				if(operacao.getTipo() == TipoOperacao.DEBITO) {
					conta.setSaldo(conta.getSaldo() + operacao.getValor());
					
					return conta;
				} else {
					
					if(conta.getSaldo() < operacao.getValor()) {
						throw new BalanceNotEnoughToOperationException("Saldo insuficiente para completar operação");
					}
					
					conta.setSaldo(conta.getSaldo() - operacao.getValor());
					
					return conta;
				}
			}
		}
		
		throw new ItemNotFoundException("Não foi possivel encontrar esse número: " + numero);
	}
	
	public String deletar(Integer numero) {
		for (ContaModel conta : listaContas) {
			if (conta.getNumero().compareTo(numero) == 0) {
				listaContas.remove(listaContas.indexOf(conta));
				
				return "Deletado com sucesso";
			}
		}
		
		return null;
	}
}
