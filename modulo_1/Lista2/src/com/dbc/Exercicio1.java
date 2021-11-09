package com.dbc;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double desconto = 0.95;

        System.out.printf("Nome do produto: %n");
        String nome = input.nextLine();
        System.out.printf("Valor do produto: %n");
        double preco = input.nextDouble();

        for(int i = 0; i < 10; i++) {
            double valor = preco * desconto;
            double total = valor * (i + 1);
            System.out.printf("%d x R$%.2f = R$%.2f %n", i + 1, valor, total);
            desconto -= 0.05;
        }
    }
}
