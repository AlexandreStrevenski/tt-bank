package br.com.target.bank.dao.impl;

import br.com.target.bank.dao.ContaDAO;
import br.com.target.bank.entity.Cliente;
import br.com.target.bank.entity.Conta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContaDAOImpl implements ContaDAO {

  private final static Map<Long, Conta> CONTAS = new HashMap<Long, Conta>();

  static {

    Cliente cliente1 = new Cliente("Alexandre", 45678899211L);
    Cliente cliente2 = new Cliente("Joao", 44788799526l);
    Cliente cliente3 = new Cliente("Maria", 48795366078l);

    addConta(new Conta(cliente1, 400d));
    addConta(new Conta(cliente2, 100d));
    addConta(new Conta(cliente3, 6000d));
  }

  private static void addConta(Conta conta) {
    conta.setId(CONTAS.size() + 1L);
    CONTAS.put(conta.getId(), conta);
  }

  public Collection<Conta> consultar(String nome) {
    if (nome == null)
      return listarTodasContas();

    List<Conta> resultado = new ArrayList<Conta>();
    for (Conta conta : CONTAS.values()) {
      if (conta.getCliente().getNome().toLowerCase().contains(nome.toLowerCase()))
        resultado.add(conta);
    }
    return resultado;
  }

  public Conta consultarContaPorId(Long idConta) {
    return CONTAS.get(idConta);
  }

  public Conta consultarContaPorNomeCliente(String nomeCliente) {
    for (Conta conta : CONTAS.values()) {
      if (conta.getCliente().getNome().equalsIgnoreCase((nomeCliente))) {
        return conta;
      }
    }
    return null;
  }

  public Collection<Conta> listarTodasContas() {
    return CONTAS.values();
  }

  public void cadastrarConta(Conta conta) {
    addConta(conta);
  }
}
