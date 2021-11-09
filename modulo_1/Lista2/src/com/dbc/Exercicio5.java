package com.dbc;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] vetor = new int[20];

        System.out.printf("Escreva um número até o total de 20 %n");

        for(int i = 0; i < vetor.length; i++){
            System.out.printf("Número %d %n", i+1);
            vetor[i] = input.nextInt();
        }

        for(int i = vetor.length; i > 0 ; i--){
            System.out.printf("Na posição %d o número é %d %n", i, vetor[i-1]);
        }
    }
}
