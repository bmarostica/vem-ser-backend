package com.dbc.lista2.exercicio5;

import java.util.Scanner;

public class Numero {
    Scanner input = new Scanner(System.in);

    public void regressivo(){
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
