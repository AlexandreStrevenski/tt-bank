package br.com.target.bank.entity;

import java.time.LocalDate;

public class Titulo {

	private String codigoDeBarras;
	private Double valorPagamento;
	private LocalDate vencimento;
	
	
	public Titulo(String codigoDeBarras, Double valorPagamento, LocalDate vencimento) {
		this.codigoDeBarras = codigoDeBarras;
		this.valorPagamento = valorPagamento;
		this.vencimento = vencimento;
	}
	
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public Double getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public LocalDate getVencimento() {
		return vencimento;
	}
	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}
	
}
