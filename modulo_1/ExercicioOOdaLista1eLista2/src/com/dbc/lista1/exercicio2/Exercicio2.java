package com.dbc.lista1.exercicio2;

public class Exercicio2 {

    public void pedirDados(Integer nota1, Integer nota2, Integer nota3, Integer nota4){
        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        if(media >= 0 && media <= 5){
            System.out.printf("Reprovado, sua média é %.2f", media);
        }
        else if(media >= 5.1 && media <= 6.9){
            System.out.printf("Em exame, sua média é %.2f", media);
        }
        else{
            System.out.printf("Aprovado, sua média é %.2f", media);
        }
    }
}
