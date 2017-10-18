package br.com.target.bank.exceptions;

public class SaldoInsuficienteException extends Exception {

  private Double valorTentativa;

  public SaldoInsuficienteException(Double valorTentativa) {
    this.valorTentativa = valorTentativa;
  }

  public Double getValorTentativa() {
    return valorTentativa;
  }
}
