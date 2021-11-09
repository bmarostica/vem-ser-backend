package com.dbc;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirCliente(){
        System.out.printf("Nome: %s%n", nome);
        System.out.printf("CPF: %s%n%n", cpf);
        imprimirEndereco();
        imprimirContatos();
    }

    public void imprimirContatos(){
        for(int i = 0; i < contatos.length; i++){
            if(contatos[i] != null){
                contatos[i].imprimirContato();
            }
        }
    }

    public void imprimirEndereco(){
        for(int i = 0; i < enderecos.length; i++){
            if(enderecos[i] != null){
                enderecos[i].imprimirEndereco();
            }
        }
    }

    public String toString(){
        return this.nome;
    }
}
