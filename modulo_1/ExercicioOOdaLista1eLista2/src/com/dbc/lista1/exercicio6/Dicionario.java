package com.dbc.lista1.exercicio6;

import java.util.Scanner;

public class Dicionario {
    Scanner input = new Scanner(System.in);


    public void tradutor(){
        System.out.printf("Escolha um dicionário: %n");
        System.out.printf("1 - Português -> Inglês %n");
        System.out.printf("2 - Inglês -> Português %n");
        int dicionario = input.nextInt();
        input.nextLine();

        if(dicionario == 1) {
            System.out.printf("Escolha a palavra para traduzir: %n");

            String[] portugues = {"Cachorro", "Tempo", "Amor", "Cidade", "Feliz"};
            String[] portuguesIngles = {"Dog", "Time", "Love", "City", "Happy"};

            System.out.printf("-Cachorro %n-Tempo %n-Amor %n-Cidade %n-Feliz %n");
            String palavra = input.nextLine();

            for (int i = 0; i < portugues.length; i++) {
                if (palavra.equalsIgnoreCase(portugues[i])) {
                    System.out.printf("%s", portuguesIngles[i]);
                    break;
                }
            }
        }

        else if(dicionario == 2){
                System.out.printf("Escolha a palavra para traduzir: %n");

                String[] ingles = {"Dog", "Time", "Love", "City", "Happy"};
                String[] inglesPortugues = {"Cachorro", "Tempo", "Amor", "Cidade", "Feliz"};

                System.out.printf("-Dog %n-Time %n-Love %n-City %n-Happy %n");
                String palavra = input.nextLine();

                for (int i = 0; i < ingles.length; i++) {
                    if (palavra.equalsIgnoreCase(ingles[i])) {
                        System.out.printf("%s", inglesPortugues[i]);
                        break;
                    }
                }
        }
        else{
            System.out.printf("Opção inválida");
       }

    }
}
