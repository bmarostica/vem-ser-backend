package com.dbc;

public class Contato {
    private String descricao;
    private String telefone;
    private Integer tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato(){
        System.out.printf("Tipo: %d%n", getTipo());
        System.out.printf("Descrição: %s%n", getDescricao());
        System.out.printf("Telefone: %s%n%n", getTelefone());
    }
}
