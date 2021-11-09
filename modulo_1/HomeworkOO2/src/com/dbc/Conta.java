package com.dbc;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Boolean sacar(Double saque){
        if(saque > saldo || saque < 1){
            return false;
        }
        else{
            setSaldo(getSaldo() - saque);
            return true;
        }
    }

    @Override
    public Boolean depositar(Double deposito){
        if(deposito < 1){
            return false;
        }
        else{
            setSaldo(getSaldo() + deposito);
            return true;
        }
    }

    @Override
    public Boolean transferir(Conta conta, Double valor){
        if(valor < 1 || valor > saldo){
            return false;
        }
        else{
            sacar(valor);
            conta.depositar(valor);
            return true;
        }
    }
}
