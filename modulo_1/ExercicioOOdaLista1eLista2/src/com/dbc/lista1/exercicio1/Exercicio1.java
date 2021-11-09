package com.dbc.lista1.exercicio1;

import java.util.Scanner;

public class Exercicio1 {
    Scanner input = new Scanner(System.in);

    private String nome;
    private Integer idade;
    private String cidade;
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void dados(){
        System.out.printf("Digite seu nome: ");
        setNome(input.nextLine());

        System.out.printf("Digite sua idade: ");
        setIdade(input.nextInt());
        input.nextLine();

        System.out.printf("Digite sua cidade: ");
        setCidade(input.nextLine());

        System.out.printf("Digite seu Estado: ");
        setEstado(input.nextLine());

        System.out.printf("Olá meu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s.", getNome(), getIdade(), getCidade(), getEstado());
    }
}
