package br.com.target.bank.dao;

import java.util.Collection;

import br.com.target.bank.entity.Conta;

public interface ContaDAO {

	public Collection<Conta> consultar(String nome);		
	public Conta consultarContaPorId(Long idConta);
	public Conta consultarContaPorNomeCliente(String nomeCliente);
	public Collection<Conta> listarTodasContas();	
	public void cadastrarConta(Conta conta);
}
