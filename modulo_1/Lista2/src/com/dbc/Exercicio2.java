package com.dbc;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero1 = 0;
        int numero2 = 0;

        System.out.printf("Pessoa 1, digite um número: %n");
        numero1 = input.nextInt();
        input.nextLine();

        do {
            System.out.printf("Pessoa 2, adivinhe o número: %n");
            numero2 = input.nextInt();
            input.nextLine();

            if (numero2 == numero1) {
                System.out.printf("VOCÊ ACERTOU MAAA OIIIII");
            } else if (numero2 > numero1) {
                System.out.printf("O número a ser adivinhado é menor que o informado. %n");
            } else {
                System.out.printf("O número a ser adivinhado é maior que o informado %n");
            }
        }while(numero2 != numero1);
    }
}
