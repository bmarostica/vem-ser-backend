package com.dbc.lista2.exercicio6;

import java.util.Scanner;

public class Adivinhar {
    Scanner input = new Scanner(System.in);

    int[] vetor = {1, 12, 14, 32, 27, 46, 6, 50, 23, 38};
    String valor = null;

    public void adivinharNumero(){
        System.out.printf("Informe um número %n");
        int num = input.nextInt();
        input.nextLine();

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] != num) {
                valor = "Valor informado inexistente";
            }
            else{
                break;
            }
        }

        System.out.println(num);
    }
}
