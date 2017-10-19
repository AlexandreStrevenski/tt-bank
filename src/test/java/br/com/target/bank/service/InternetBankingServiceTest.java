package br.com.target.bank.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.target.bank.dao.ContaDAO;
import br.com.target.bank.entity.Cliente;
import br.com.target.bank.entity.Conta;
import br.com.target.bank.exceptions.SaldoInsuficienteException;

@RunWith(MockitoJUnitRunner.class)
public class InternetBankingServiceTest {

  private InternetBankingService internetBanking;
  private Conta contaOrigem;
  private Conta contaDestino;

  @Mock
  private ContaDAO contaDAOMock;

  @Before
  public void setUp() {
    internetBanking = new InternetBankingService();

    Cliente cliente1 = new Cliente("Alexandre", 123654789l);
    Cliente cliente2 = new Cliente("Joao", 9877531559l);

    contaOrigem = new Conta(cliente1, 300d);
    contaDestino = new Conta(cliente2, 200d);
    internetBanking.setContaDAO(contaDAOMock);
  }


  @Test
  public void testTransferirEntreDuasContas() throws SaldoInsuficienteException {		

    Mockito.when(contaDAOMock.consultarContaPorNomeCliente("Alexandre")).thenReturn(contaOrigem);
    Mockito.when(contaDAOMock.consultarContaPorNomeCliente("Joao")).thenReturn(contaDestino);

    internetBanking.transferir(100d, contaOrigem, contaDestino);
    Double saldoEsperado = 200d;
    Double saldoEsperadoDestino = 300d;

    Assert.assertTrue(saldoEsperado.doubleValue() == contaOrigem.getSaldo() && saldoEsperadoDestino.doubleValue() == contaDestino.getSaldo());
  }

  @Test(expected=SaldoInsuficienteException.class)
  public void testTransferirSemSaldo() throws SaldoInsuficienteException {

    Mockito.when(contaDAOMock.consultarContaPorNomeCliente("Alexandre")).thenReturn(contaOrigem);
    Mockito.when(contaDAOMock.consultarContaPorNomeCliente("Joao")).thenReturn(contaDestino);

    internetBanking.transferir(4000d, contaOrigem, contaDestino);
    Double saldoEsperado = 200d;		

    Assert.assertEquals(saldoEsperado, contaOrigem.getSaldo());
  }

  @Test(timeout=10000)
  public void testTransferirSessaoExpirada() throws SaldoInsuficienteException {		

    Mockito.when(contaDAOMock.consultarContaPorNomeCliente("Alexandre")).thenReturn(contaOrigem);
    aguardar();
    Mockito.when(contaDAOMock.consultarContaPorNomeCliente("Joao")).thenReturn(contaDestino);

    internetBanking.transferir(100d, contaOrigem, contaDestino);
    Double saldoEsperado = 200d;
    Double saldoEsperadoDestino = 300d;

    Assert.assertTrue(saldoEsperado.doubleValue() == contaOrigem.getSaldo() && saldoEsperadoDestino.doubleValue() == contaDestino.getSaldo());
  }

  private void aguardar() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {

    }
  }


  @After
  public void tearDown() {
    internetBanking = null;
  }

}
