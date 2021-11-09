package com.dbc;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Escolha um dicionário: %n");
        System.out.printf("1 - Português -> Inglês %n");
        System.out.printf("2 - Inglês -> Português %n");
        int dicionario = input.nextInt();
        input.nextLine();

        if(dicionario == 1){
            System.out.printf("Escolha a palavra para traduzir: %n");
            System.out.printf("1 - Cachorro %n");
            System.out.printf("2 - Tempo %n");
            System.out.printf("3 - Amor %n");
            System.out.printf("4 - Cidade %n");
            System.out.printf("5 - Feliz %n");
            int palavra = input.nextInt();
            input.nextLine();

            switch(palavra){
                case 1:
                    System.out.printf("Dog");
                    break;
                case 2:
                    System.out.printf("Time");
                    break;
                case 3:
                    System.out.printf("Love");
                    break;
                case 4:
                    System.out.printf("City");
                    break;
                case 5:
                    System.out.printf("Happy");
                default:
                    System.out.printf("Opção inválida");
                    break;
            }
        }

        else if(dicionario == 2){
            System.out.printf("Escolha a palavra para traduzir: %n");
            System.out.printf("1 - Dog %n");
            System.out.printf("2 - Time %n");
            System.out.printf("3 - Love %n");
            System.out.printf("4 - City %n");
            System.out.printf("5 - Happy %n");
            int palavra = input.nextInt();
            input.nextLine();

            switch(palavra){
                case 1:
                    System.out.printf("Cachorro");
                    break;
                case 2:
                    System.out.printf("Tempo");
                    break;
                case 3:
                    System.out.printf("Amor");
                    break;
                case 4:
                    System.out.printf("Cidade");
                    break;
                case 5:
                    System.out.printf("Feliz");
                default:
                    System.out.printf("Opção inválida");
                    break;
            }
        }
        else{
            System.out.printf("Opção inválida");
        }
    }
}
