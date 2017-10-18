package br.com.target.bank.entity;

import java.util.Date;

public class Cliente {

  private String nome;
  private Long cpf;
  private Date dataNascimento;
  private Double salario;


  public Cliente(String nome, Long cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  public Long getCpf() {
    return cpf;
  }
  public void setCpf(Long cpf) {
    this.cpf = cpf;
  }
  public Date getDataNascimento() {
    return dataNascimento;
  }
  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
  public Double getSalario() {
    return salario;
  }
  public void setSalario(Double salario) {
    this.salario = salario;
  }


}
