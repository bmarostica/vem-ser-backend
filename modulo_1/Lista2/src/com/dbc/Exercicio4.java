package com.dbc;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] vetor = new int[3];

        System.out.printf("Informe 3 números %n");

        for(int i = 0; i < vetor.length; i++){
            System.out.printf("Número %d %n", i+1);
            vetor[i] = input.nextInt();
        }

        if (vetor[0] < vetor[1] && vetor[0] < vetor[2]) {
            System.out.printf("Posição 0 %n");
        }
        else if(vetor[1] < vetor[0] && vetor[1] < vetor[2]){
            System.out.printf("Posição 1 %n");
        }
        else{
            System.out.printf("Posição 2 %n");
        }


    }
}
