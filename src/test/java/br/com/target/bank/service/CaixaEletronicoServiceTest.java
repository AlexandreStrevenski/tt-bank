package br.com.target.bank.service;

import static org.junit.Assert.fail;

import br.com.target.bank.entity.Cliente;
import br.com.target.bank.entity.Conta;
import br.com.target.bank.exceptions.SaldoInsuficienteException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CaixaEletronicoServiceTest {
    private CaixaEletronicoService caixaEletronico;
  
    @Before
    public void setUp() {
      caixaEletronico = new CaixaEletronicoService();
    }
  
    @Test
    public void testSacarComSucesso() throws SaldoInsuficienteException {	
        Cliente cliente1 = new Cliente("Alexandre", 123654789l);
        Conta conta = new Conta(cliente1, 450d);
        caixaEletronico.sacar(100d, conta);
    
        Double valorEsperado = 350d;
        Assert.assertEquals(valorEsperado, conta.getSaldo());
    }
  
    @Test(expected = SaldoInsuficienteException.class)
    public void testSacarSemSaldo() throws SaldoInsuficienteException {
      Cliente cliente1 = new Cliente("Alexandre", 123654789L);
      Conta conta = new Conta(cliente1, 450d);
      caixaEletronico.sacar(1500d, conta);
      fail();
    }
  
    @After
    public void tearDown() {
      caixaEletronico = null;
    }

}
