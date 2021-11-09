package com.dbc;

public class ContaPoupanca extends Conta implements Impressao {
    final static double JUROS_MENSAL = 1.01;

    public void creditarTaxa(){
        setSaldo(getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.printf("Saldo conta poupança: R$%.2f %n", getSaldo());

    }
}
