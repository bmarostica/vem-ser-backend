package com.dbc;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Calculadora de salário %n");
        System.out.printf("Informe o valor em R$ da hora trabalhada: ");
        double valorDaHora = input.nextDouble();
        System.out.printf("Quantidade de horas normais trabalhadas: ");
        int horasNormaisTrabalhadas = input.nextInt();
        input.nextLine();
        System.out.printf("Quantidade de horas extras 50%% trabalhadas: ");
        int horasExtrasCinquentaPorcentoTrabalhadas = input.nextInt();
        input.nextLine();
        System.out.printf("Quantidade de horas extras 100%% trabalhadas: ");
        int horasExtrasCemPorcentoTrabalhadas = input.nextInt();
        input.nextLine();

        double salario = (valorDaHora * horasNormaisTrabalhadas) +
                (horasExtrasCinquentaPorcentoTrabalhadas * (valorDaHora / 2)) +
                (horasExtrasCemPorcentoTrabalhadas * valorDaHora);

        System.out.printf("Seu salário bruto é de R$%.2f", salario);


    }
}
