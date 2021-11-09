package com.dbc;

public class Contato {
    String descricao;
    String telefone;
    Integer tipo;

    public void imprimirContato(){
        System.out.printf("Descrição: %s%n", descricao);
        System.out.printf("Telefone: %s%n", telefone);
        System.out.printf("Tipo: %d%n%n", tipo);
    }
}
