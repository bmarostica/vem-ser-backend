package com.dbc;

public class ContaCorrente extends Conta implements Impressao{
    private Double chequeEspecial;

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public Double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }

    @Override
    public Boolean sacar(Double saque){
        if(saque > chequeEspecial + getSaldo()  || saque < 1){
            return false;
        }
        else{
            setSaldo(getSaldo() - saque);
            return true;
        }
    }

    @Override
    public void imprimir() {
        System.out.printf("Valor cheque especial: R$%.2f %n", chequeEspecial);
        System.out.printf("Saldo conta corrente: R$%.2f %n", getSaldo());
    }
}
