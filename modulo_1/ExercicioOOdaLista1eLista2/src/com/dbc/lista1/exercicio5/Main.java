package com.dbc.lista1.exercicio5;

public class Main {
    public static void main(String[] args) {
        Exercicio5 exercicio = new Exercicio5(12.35, 15, 27, 32);
        exercicio.calculoSalario();
        exercicio.setHorasExtrasCemPorcentoTrabalhadas(35);
        exercicio.calculoSalario();
    }



}
