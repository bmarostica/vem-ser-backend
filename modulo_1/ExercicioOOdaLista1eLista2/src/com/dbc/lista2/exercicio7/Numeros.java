package com.dbc.lista2.exercicio7;

import java.util.Scanner;

public class Numeros {
    Scanner input = new Scanner(System.in);

    public void contador() {

        int[][] matriz = new int[4][4];
        int contador = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf("Informe um número para a linha %d, coluna %d %n", (i + 1), (j + 1));
                matriz[i][j] = input.nextInt();
                input.nextLine();

                if (matriz[i][j] > 10) {
                    contador++;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.printf("A quantidade de valores maiores do que 10 é de %d", contador);
    }
}
