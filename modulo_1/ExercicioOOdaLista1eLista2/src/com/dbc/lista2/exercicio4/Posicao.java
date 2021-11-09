package com.dbc.lista2.exercicio4;

import java.util.Scanner;

public class Posicao {
    Scanner input = new Scanner(System.in);

    public void posicao() {
        int[] vetor = new int[3];
        System.out.printf("Informe 3 números %n");

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Número %d %n", i + 1);
            vetor[i] = input.nextInt();
        }
        if (vetor[0] < vetor[1] && vetor[0] < vetor[2]) {
            System.out.println("Posição 0");

        } else if (vetor[1] < vetor[0] && vetor[1] < vetor[2]) {
            System.out.println("Posição 1");
        } else {
            System.out.println("Posição 2");
        }
    }
}
