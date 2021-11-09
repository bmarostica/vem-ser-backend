package com.dbc.lista2.exercicio3;

import java.util.Scanner;

public class Jogador {
    Scanner input = new Scanner(System.in);

    private int jogadoresCadastrados = 0;
    private double alturaMaiorJogador = 0;
    private int jogadorMaisVelho = 0;
    private String nomeJogadorMaisVelho = null;
    private double jogadorMaisPesado = 0;
    private String nomeJogadorMaisPesado = null;
    private double somaAltura = 0;
    private String nome = null;
    private double altura = 0;
    private int idade = 0;
    private double peso = 0;
    private double mediaAlturas;


    public void cadastro() {
        do {
            System.out.printf("Preencha os dados do jogador: %n");
            System.out.printf("Nome: ");
            nome = input.nextLine();

            if(nome.equalsIgnoreCase("sair")){
                break;
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

            if (alturaMaiorJogador < altura) {
                alturaMaiorJogador = altura;
            }

            if (idade > jogadorMaisVelho) {
                jogadorMaisVelho = idade;
                nomeJogadorMaisVelho = nome;
            }

            if (peso > jogadorMaisPesado) {
                jogadorMaisPesado = peso;
                nomeJogadorMaisPesado = nome;
            }

        } while (!nome.equalsIgnoreCase("sair"));
    }

    public void imprimirDados() {
        mediaAlturas = somaAltura / jogadoresCadastrados;

        System.out.printf("Quantidade de jogadores cadastrados: %d%n", jogadoresCadastrados);
        System.out.printf("Altura do maior jogador: %.2f %n", alturaMaiorJogador);
        System.out.printf("Jogador mais velho: %s%n", nomeJogadorMaisVelho);
        System.out.printf("Jogador mais pesado: %s %n", nomeJogadorMaisPesado);
        System.out.printf("Média das alturas dos jogadores: %.2f %n", mediaAlturas);
    }

}
