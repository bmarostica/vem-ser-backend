package com.dbc;

import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] vetor = {1, 12, 14, 32, 27, 46, 6, 50, 23, 38};
        String valor = null;

        System.out.printf("Informe um número %n");
        int num = input.nextInt();
        input.nextLine();

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] != num) {
                valor = "Valor informado inexistente";
            }
            else{
                System.exit(0);
            }
        }

        System.out.printf(valor);
    }
}
