package com.dbc.lista2.exercicio2;

import java.util.Scanner;

public class Numero {
    Scanner input = new Scanner(System.in);

    int numero1 = 0;
    int numero2 = 0;

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public void adivinhar(){
        System.out.printf("Pessoa 1, digite um número: %n");
        setNumero1(input.nextInt());
        input.nextLine();

        do {
            System.out.printf("Pessoa 2, adivinhe o número: %n");
            setNumero2(input.nextInt());
            input.nextLine();

            if (getNumero2() == getNumero1()) {
                System.out.printf("VOCÊ ACERTOU MAAA OIIIII");
            } else if (getNumero2() > getNumero1()) {
                System.out.printf("O número a ser adivinhado é menor que o informado. %n");
            } else {
                System.out.printf("O número a ser adivinhado é maior que o informado %n");
            }
        }while(getNumero2() != getNumero1());
    }

}
