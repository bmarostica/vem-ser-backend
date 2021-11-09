package com.dbc.lista1.exercicio5;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Exercicio5 {
    Scanner input = new Scanner(System.in);

    Double valorHora;
    Integer horasNormaisTrabalhadas;
    Integer horasExtrasCinquentaPorcentoTrabalhadas;
    Integer horasExtrasCemPorcentoTrabalhadas;

    public Exercicio5(Double valorHora, Integer horasNormaisTrabalhadas, Integer horasExtrasCinquentaPorcentoTrabalhadas, Integer horasExtrasCemPorcentoTrabalhadas) {
        this.valorHora = valorHora;
        this.horasNormaisTrabalhadas = horasNormaisTrabalhadas;
        this.horasExtrasCinquentaPorcentoTrabalhadas = horasExtrasCinquentaPorcentoTrabalhadas;
        this.horasExtrasCemPorcentoTrabalhadas = horasExtrasCemPorcentoTrabalhadas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public Integer getHorasNormaisTrabalhadas() {
        return horasNormaisTrabalhadas;
    }

    public void setHorasNormaisTrabalhadas(Integer horasNormaisTrabalhadas) {
        this.horasNormaisTrabalhadas = horasNormaisTrabalhadas;
    }

    public Integer getHorasExtrasCinquentaPorcentoTrabalhadas() {
        return horasExtrasCinquentaPorcentoTrabalhadas;
    }

    public void setHorasExtrasCinquentaPorcentoTrabalhadas(Integer horasExtrasCinquentaPorcentoTrabalhadas) {
        this.horasExtrasCinquentaPorcentoTrabalhadas = horasExtrasCinquentaPorcentoTrabalhadas;
    }

    public Integer getHorasExtrasCemPorcentoTrabalhadas() {
        return horasExtrasCemPorcentoTrabalhadas;
    }

    public void setHorasExtrasCemPorcentoTrabalhadas(Integer horasExtrasCemPorcentoTrabalhadas) {
        this.horasExtrasCemPorcentoTrabalhadas = horasExtrasCemPorcentoTrabalhadas;
    }

    public void calculoSalario(){
        double salario = (valorHora * horasNormaisTrabalhadas) +
                (horasExtrasCinquentaPorcentoTrabalhadas * (valorHora * 0.5) +
                (horasExtrasCemPorcentoTrabalhadas * valorHora * 2));

        System.out.printf("Seu salário bruto é de R$%.2f%n", salario);
    }
}
