package br.com.target.bank.entity;

public class Conta {

    private Long id;
    private Cliente cliente;
    private Double saldo;

    public Conta(Cliente cliente, Double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNomeCliente() {
      return this.cliente.getNome();
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
