package com.dbc.lista2.exercicio1;

import java.util.Scanner;

public class Produto {
    Scanner input = new Scanner(System.in);

    double desconto = 0.95;

    private String produto;
    private Double preco;


    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void calculo() {

        System.out.printf("Nome do produto: %n");
        setProduto(input.nextLine());
        System.out.printf("Valor do produto: %n");
        setPreco(input.nextDouble());

        for (int i = 0; i < 10; i++) {
            double valor = getPreco() * desconto;
            double total = valor * (i + 1);
            System.out.printf("%d x R$%.2f = R$%.2f %n", i + 1, valor, total);
            desconto -= 0.05;
        }
    }

}
