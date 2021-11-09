package com.dbc;

public class ContaPagamento extends Conta implements Impressao{
     final static Double TAXA_SAQUE = 4.25;

    @Override
    public Boolean sacar(Double saque) {
        return super.sacar(saque + TAXA_SAQUE);
    }

    @Override
    public void imprimir() {
        System.out.printf("Saldo conta pagamento: R$%.2f %n%n", getSaldo());
    }
}
