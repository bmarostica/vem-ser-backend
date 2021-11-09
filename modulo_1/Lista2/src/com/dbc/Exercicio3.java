package com.dbc;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jogadoresCadastrados = 0;
        double alturaMaiorJogador = 0;
        int jogadorMaisVelho = 0;
        String nomeJogadorMaisVelho = null;
        double jogadorMaisPesado = 0;
        String nomeJogadorMaisPesado = null;
        double somaAltura = 0;
        String nome = null;
        double altura = 0;
        int idade = 0;
        double peso = 0;

        do{
            if(jogadoresCadastrados == 0) {
                System.out.printf("Preencha os dados do jogador: %n");
                System.out.printf("Nome: ");
                nome = input.nextLine();
            }

            System.out.printf("Altura: ");
            altura = input.nextDouble();
            System.out.printf("Idade: ");
            idade = input.nextInt();
            System.out.printf("Peso: ");
            peso = input.nextDouble();
            input.nextLine();

            System.out.printf("Nome: %s %n", nome);
            System.out.printf("Altura: %.2f %n", altura);
            System.out.printf("Idade: %d %n", idade);
            System.out.printf("Peso: %.2f %n%n", peso);

            jogadoresCadastrados++;
            somaAltura += altura;

            if(alturaMaiorJogador < altura){
                alturaMaiorJogador = altura;
            }

            if(idade > jogadorMaisVelho){
                jogadorMaisVelho = idade;
                nomeJogadorMaisVelho = nome;
            }

            if(peso > jogadorMaisPesado){
                jogadorMaisPesado = peso;
                nomeJogadorMaisPesado = nome;
            }

            System.out.printf("Preencha os dados do jogador: %n");
            System.out.printf("Nome: ");
            nome = input.nextLine();

        }while(!nome.equalsIgnoreCase("sair"));

        double mediaAlturas = somaAltura / jogadoresCadastrados;

        System.out.printf("Quantidade de jogadores cadastrados: %d%n", jogadoresCadastrados);
        System.out.printf("Altura do maior jogador: %.2f %n", alturaMaiorJogador);
        System.out.printf("Jogador mais velho: %s%n", nomeJogadorMaisVelho);
        System.out.printf("Jogador mais pesado: %s %n", nomeJogadorMaisPesado);
        System.out.printf("Média das alturas dos jogadores: %.2f %n", mediaAlturas);

    }
}
