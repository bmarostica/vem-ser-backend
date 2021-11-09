package com.dbc;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Digite seu nome: ");
        String nome = input.nextLine();

        System.out.printf("Digite sua idade: ");
        int idade = input.nextInt();

        System.out.printf("Digite sua cidade: ");
        String cidade = input.nextLine();

        System.out.printf("Digite seu Estado: ");
        String estado = input.nextLine();

        System.out.printf("Olá seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s.", nome, idade, cidade, estado);
    }
}
