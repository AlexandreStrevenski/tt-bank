package br.com.target.bank.service;

import br.com.target.bank.entity.Conta;
import br.com.target.bank.entity.Titulo;
import br.com.target.bank.exceptions.SaldoInsuficienteException;
import br.com.target.bank.exceptions.TituloVencidoException;

public class CaixaEletronicoService {

	public void sacar(Double valorSaque, Conta conta) throws SaldoInsuficienteException {
		if (conta.getSaldo() > valorSaque) {
			Double novoSaldo = conta.getSaldo() - valorSaque;
			conta.setSaldo(novoSaldo);	
		}else {
			throw new SaldoInsuficienteException(valorSaque);
		}
	}
	
	public void pagarTitulo(Titulo titulo, Conta conta) throws SaldoInsuficienteException, TituloVencidoException {
	  	
	  new TituloService().pagarTitulo(titulo, conta);
	}

}
