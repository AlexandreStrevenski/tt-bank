package br.com.target.bank.service;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.target.bank.entity.Cliente;
import br.com.target.bank.entity.Conta;
import br.com.target.bank.entity.Titulo;
import br.com.target.bank.exceptions.SaldoInsuficienteException;
import br.com.target.bank.exceptions.TituloVencidoException;


public class TituloServiceTest {

	private TituloService tituloService;
	private Conta conta; 
	
	@Before
	public void setUp() {
		tituloService = new TituloService();
		conta = new Conta(new Cliente("Alex", 12645678977l), 300d);
	}
	
	@Test
	public void testPagarTitulo() throws SaldoInsuficienteException, TituloVencidoException {
		LocalDate date = LocalDate.of(2017, 11, 5);
		Titulo titulo = new Titulo("34191.23454 61234.590026 31234.550007 6 70000015300150", 150d, date);

		tituloService.pagarTitulo(titulo, conta);
	}
	
	
	@Ignore
	@Test(expected=TituloVencidoException.class)
	public void pagarTituloVencido() throws SaldoInsuficienteException, TituloVencidoException {
		//TODO: 2) Implementar a validacao de titulo vencido
	}
	
	@After
	public void tearDown() {
		tituloService = null;
		conta = null;
	}
	
	//TODO: 1) Criar o metodo tearDown
	
}
