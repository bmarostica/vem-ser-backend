package com.dbc;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Informe o valor gasto: R$%n");
        double valorConsumido = input.nextDouble();
        System.out.printf("Informe o valor recebido: R$ %n");
        double valorPago = input.nextDouble();

        if (valorPago < valorConsumido){
            System.out.printf("O valor pago deve ser maior ou igual ao valor de consumido");
        }
        else{
            double troco = valorPago - valorConsumido;
            System.out.printf("O troco é de R$%.2f", troco);
        }

    }
}
