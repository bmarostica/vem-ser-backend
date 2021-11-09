package com.dbc;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    Integer agencia;
    Double saldo;
    Double chequeEspecial;

    public void imprimirContaCorrente(){
        System.out.printf("Cliente: %s%n", this.cliente);
        System.out.printf("Agência: %d \t Número da conta: %s%n", agencia, numeroConta);
        System.out.printf("Saldo: %.2f %n", saldo);
        System.out.printf("Cheque Especial: %.2f %n%n", chequeEspecial);
    }

    public Double retornarSaldoComChequeEspecial(){
        Double saldoTotal = saldo + chequeEspecial;
        return saldoTotal;
    }

    public boolean sacar(Double saque){
        if(saque > saldo || saque < 1){
            return false;
        }
        else{
            saldo -= saque;
            return true;
        }
    }

    public boolean depositar(Double deposito){
        if(deposito < 1){
            return false;
        }
        else{
            saldo += deposito;
            return true;
        }
    }

    public boolean transferir(ContaCorrente contaCorrente, Double valor){
        if(valor < 1 || valor > saldo){
            return false;
        }
        else{
            sacar(valor);
            contaCorrente.depositar(valor);
            return true;
        }
    }
}
