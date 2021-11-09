package com.dbc;

public class Endereco {
    Integer tipo;
    String logradouro;
    Integer numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco(){
        System.out.printf("Tipo: %s%n", tipo);
        System.out.printf("Logradouro: %s, nº %d. Complemento: %s. CEP: %s%n", logradouro, numero, complemento, cep);
        System.out.printf("Cidade: %s. Estado: %s. País: %s%n%n", cidade, estado, pais);
    }
}
