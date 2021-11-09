package com.dbc.lista2.exercicio8;

import java.util.Scanner;

public class Calculo {
    Scanner input = new Scanner(System.in);

    private int soma = 0;
    private double notaFinal = 0;
    private int matriculaMaiorNotaFinal = 0;
    private int matriculaMaiorNota = 0;

    private int[][] matriz = {{99, 15, 18, 0},
            {98, 18, 9, 0},
            {97, 20, 14, 0},
            {96, 15, 25, 0},
            {95, 13, 21, 0}};


    public void lerMatriz() {
        System.out.printf("Matricula \t Média das provas \t Média dos trabalhos %n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[j].length - 1; j++) {
                System.out.print(matriz[i][j] + "\t\t\t\t\t");
            }
            System.out.println("");
        }
    }

    public void calculoNotas() {
        System.out.printf("%nMatricula \t Média das provas \t Média dos trabalhos  \t Nota final %n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[j].length; j++) {
                notaFinal = (matriz[i][1] * 0.6 + matriz[i][2] * 0.4);
                matriz[i][3] = (int) notaFinal;
                System.out.print(matriz[i][j] + "\t\t\t\t\t");
            }
            System.out.println("");
        }
    }

    public void imprimirMatriculaECalculoMedia() {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][3] > matriculaMaiorNotaFinal) {
                matriculaMaiorNotaFinal = matriz[i][3];
                matriculaMaiorNota = matriz[i][0];
            }
            soma += notaFinal;
        }
        System.out.printf("%nMatrícula que obteve maior nota final: %d %nMédia das notas finais: %d", matriculaMaiorNota, (soma / 5));
    }

}
