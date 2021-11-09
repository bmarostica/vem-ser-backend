package com.dbc.lista1.exercicio3;

import java.util.Scanner;

public class Exercicio3 {
    Scanner input = new Scanner(System.in);

    public void troco(Double valorConsumido, Double valorPago){
        Double troco = 0.00;

        if (valorPago < valorConsumido){
            System.out.printf("O valor pago deve ser maior ou igual ao valor de consumido");
        }
        else {
            troco = valorPago - valorConsumido;
            System.out.printf("O troco é de R$%.2f", troco);
        }
    }



}
