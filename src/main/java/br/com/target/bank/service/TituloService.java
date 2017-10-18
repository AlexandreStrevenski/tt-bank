package br.com.target.bank.service;

import java.time.LocalDate;

import br.com.target.bank.dao.ContaDAO;
import br.com.target.bank.dao.MinhaAnotacaoQueFazAlgo;
import br.com.target.bank.dao.impl.ContaDAOImpl;
import br.com.target.bank.entity.Conta;
import br.com.target.bank.entity.Titulo;
import br.com.target.bank.exceptions.SaldoInsuficienteException;
import br.com.target.bank.exceptions.TituloVencidoException;

public class TituloService {

	private ContaDAO contaDAO;
	
	public TituloService() 	{
		this.contaDAO = new ContaDAOImpl();
	}
	
	public void pagarTitulo(Titulo titulo, Conta conta) throws SaldoInsuficienteException, TituloVencidoException {
		
		if (titulo.getVencimento().isBefore(LocalDate.now())) {
			throw new TituloVencidoException();
		}
		
		if (conta.getSaldo() >= titulo.getValorPagamento()) {
			conta.setSaldo(conta.getSaldo() - titulo.getValorPagamento());
		}else {
			throw new SaldoInsuficienteException(titulo.getValorPagamento());
		}
	}

}
