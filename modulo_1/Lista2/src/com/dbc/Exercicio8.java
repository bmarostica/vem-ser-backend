package com.dbc;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int soma = 0;
        double notaFinal = 0;
        int matriculaMaiorNotaFinal = 0;
        int matriculaMaiorNota = 0;

        //matriz de [5]linhas [4]colunas
        int[][] matriz = {{99, 15, 18, 0},
                {98, 18, 9, 0},
                {97, 20, 14, 0},
                {96, 15, 25, 0},
                {95, 13, 21, 0}};

//        int[][] matriz = new int[5][4];
//        for(int i = 0; i < matriz.length; i++){
//            for(int j = 0; j < matriz.length-1; j++) {
//                System.out.printf("Informe um número para a linha %d, coluna %d %n", (i+1), (j+1));
//                matriz[i][j] = input.nextInt();
//                input.nextLine();
//            }
//        }

        //leitura da matriz
        System.out.printf("Matricula \t Média das provas \t Média dos trabalhos %n");
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[j].length-1; j++) {
                System.out.print(matriz[i][j] + "\t\t\t\t\t");
            }
            System.out.println("");
        }

        //calculo nota final (media das provas * 0,6 + media dos trabalhos * 0,4)
        System.out.printf("%nMatricula \t Média das provas \t Média dos trabalhos  \t Nota final %n");
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[j].length; j++) {
                notaFinal = (matriz[i][1] * 0.6 + matriz[i][2] * 0.4);
                matriz[i][3] = (int) notaFinal;
                System.out.print(matriz[i][j] + "\t\t\t\t\t");
            }
            System.out.println("");
        }

        //imprimir a matrícula com maior nota final e calculo de soma para média das notas finais
        for(int i = 0; i < matriz.length; i++){
            if(matriz[i][3] > matriculaMaiorNotaFinal){
                matriculaMaiorNotaFinal = matriz[i][3];
                matriculaMaiorNota = matriz[i][0];
            }
            soma+= notaFinal;
        }
        System.out.printf("%nMatrícula que obteve maior nota final: %d %nMédia das notas finais: %d", matriculaMaiorNota, (soma/5));
    }
}
