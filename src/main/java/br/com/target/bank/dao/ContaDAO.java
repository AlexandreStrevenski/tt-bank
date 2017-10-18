package br.com.target.bank.dao;

import br.com.target.bank.entity.Conta;
import java.util.Collection;

public interface ContaDAO {

  Collection<Conta> consultar(String nome);

  Conta consultarContaPorId(Long idConta);

  Conta consultarContaPorNomeCliente(String nomeCliente);

  Collection<Conta> listarTodasContas();

  void cadastrarConta(Conta conta);

}
