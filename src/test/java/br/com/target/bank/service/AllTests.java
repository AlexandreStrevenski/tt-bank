package br.com.target.bank.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CaixaEletronicoServiceTest.class, InternetBankingServiceTest.class, TituloServiceTest.class})
public class AllTests {

}
