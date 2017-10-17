package br.com.target.bank.service;


import br.com.target.bank.dao.ContaDAO;
import br.com.target.bank.dao.impl.ContaDAOImpl;
import br.com.target.bank.entity.Conta;
import br.com.target.bank.entity.Titulo;
import br.com.target.bank.exceptions.SaldoInsuficienteException;
import br.com.target.bank.exceptions.TituloVencidoException;

public class InternetBankingService {

	private ContaDAO contaDAO;
	
	public InternetBankingService() {
		this.contaDAO = new ContaDAOImpl();
	}
	
	public void transferir(Double valorTransferencia, Conta contaOrigem, Conta contaDestino) throws SaldoInsuficienteException {
		
		Conta contaOrigemVerificada = contaDAO.consultarContaPorNomeCliente(contaOrigem.getCliente().getNome());
		Conta contaDestinoVerificada = contaDAO.consultarContaPorNomeCliente(contaDestino.getCliente().getNome());
		
		if (valorTransferencia > contaOrigemVerificada.getSaldo()) {
			throw new SaldoInsuficienteException(valorTransferencia);
		}
		
		Double novoSaldo = contaOrigemVerificada.getSaldo() - valorTransferencia;
		contaOrigemVerificada.setSaldo(novoSaldo);
		
		Double novoSaldoDestino = contaDestinoVerificada.getSaldo() + valorTransferencia;
		contaDestinoVerificada.setSaldo(novoSaldoDestino);
	}

	public void pagarTitulo(Titulo titulo, Conta conta) throws SaldoInsuficienteException, TituloVencidoException {
		new TituloService().pagarTitulo(titulo, conta);
	}
	
	public void setContaDAO(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

}
