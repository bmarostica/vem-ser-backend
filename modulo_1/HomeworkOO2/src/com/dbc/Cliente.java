package com.dbc;

public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    public void imprimirCliente(){
        System.out.printf("Nome: %s%n", getNome());
        System.out.printf("CPF: %s%n%n", getCpf());
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
