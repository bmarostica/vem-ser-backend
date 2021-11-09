package com.dbc;

public interface Movimentacao {
    Boolean sacar(Double saque);
    Boolean depositar(Double deposito);
    Boolean transferir(Conta conta, Double valor);
}
