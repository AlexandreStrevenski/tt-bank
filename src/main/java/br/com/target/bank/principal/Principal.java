package br.com.target.bank.principal;


import br.com.target.bank.dao.ContaDAO;
import br.com.target.bank.dao.impl.ContaDAOImpl;
import br.com.target.bank.entity.Cliente;
import br.com.target.bank.entity.Conta;
import br.com.target.bank.exceptions.SaldoInsuficienteException;
import br.com.target.bank.service.InternetBankingService;

public class Principal {

  public static void main(String[] args) {

    ContaDAO contaDAO = new ContaDAOImpl();
    InternetBankingService IB = new InternetBankingService();

    Cliente clienteAlexandre = new Cliente("Alexandre", 123654789l);
    Cliente clienteJoao = new Cliente("Joao", 9877531559l);

    Conta contaAlex = new Conta(clienteAlexandre, 200d);
    Conta contaJoao = new Conta(clienteJoao, 700d);

    contaDAO.cadastrarConta(contaAlex);
    contaDAO.cadastrarConta(contaJoao);

    try {
      IB.transferir(150d, contaAlex, contaJoao);

      System.out.println("Transferencia concluida com sucesso");
      System.out.println(contaAlex.getCliente().getNome() + " com saldo de: " + contaAlex.getSaldo());
    } catch (SaldoInsuficienteException e) {
     // System.out.println("Nao foi possivel efetivar a transferencia de " + e.getValorTentativa());
    }

  }

}
