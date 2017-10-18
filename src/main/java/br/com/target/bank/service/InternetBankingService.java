package br.com.target.bank.service;

import br.com.target.bank.dao.ContaDAO;
import br.com.target.bank.dao.impl.ContaDAOImpl;
import br.com.target.bank.entity.Conta;
import br.com.target.bank.entity.Titulo;
import br.com.target.bank.exceptions.SaldoInsuficienteException;
import br.com.target.bank.exceptions.TituloVencidoException;

/**
 * Classe simples de teste para o Modelo Funcionario.
 * 
 * @author Gilberto Lupatini
 */
public class InternetBankingService {

  private ContaDAO contaDAO;

  public InternetBankingService() {
    this.contaDAO = new ContaDAOImpl();
  }

  /** 
   * @param valorTransferencia valor a ser debitado de uma conta e creditado em outra
   * @param contaOrigem indica a conta de origem
   * @param contaDestino indica a conta de destino
   * @throws SaldoInsuficienteException pode acontecer caso nao tenha saldo na conta de origem
   */
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
    
    if (valorTransferencia > contaOrigemVerificada.getSaldo()) {
      throw new SaldoInsuficienteException(valorTransferencia);
    }
  }

  public void pagarTitulo(Titulo titulo, Conta conta) 
      throws SaldoInsuficienteException, TituloVencidoException {
    new TituloService().pagarTitulo(titulo, conta);
  }

  public void setContaDAO(ContaDAO contaDAO) {
    this.contaDAO = contaDAO;
  }

}
