package com.dbc.lista1.exercicio4;

import java.util.Scanner;

public class Exercicio4 {
    Scanner input = new Scanner(System.in);

    Integer cidade;
    Integer estado;




    public void imprimirDados() {
        System.out.printf("Escolha um dos seguintes Estados: %n");
        System.out.printf("1 - Rio Grande Do Sul %n");
        System.out.printf("2 - São Paulo %n");
        System.out.printf("3 - Bahia %n");
        estado = input.nextInt();
        input.nextLine();


        switch (estado){
            case 1:
                System.out.printf("Selecione uma cidade: 1 - Porto Alegre ou 2 - Caxias do Sul %n");
                cidade = input.nextInt();
                input.nextLine();

                if(cidade == 1){
                    System.out.printf("Porto Alegre %n Sua população é de aproximadamente 517.451 habitantes. %n Com IDH de 0,805 %n");
                    System.out.printf("Sua festa mais famosa é a tradicional  Semana Farroupilha que ocorre em Setembro %n");
                    System.out.printf("Pontos turisticos: Estatua do Laçador, Usina do Gasometro, Casa de cultura Mario Quintana, entre outros");
                }
                else if(cidade == 2){
                    System.out.printf("Caxias do Sul %n Sua população é de aproximadamente 11.466.630 de habitantes. %n Com IDH de 0,782 %n");
                    System.out.printf("Sua festa mais famosa é Festa da Uva %n");
                    System.out.printf("Pontos turisticos: Vinicola Cantina Tonet, Igreja São Pellegrino, Castelo Lacave entre outros.");
                }
                else{
                    System.out.printf("Cidade inexistente");
                }
                break;
            case 2:
                System.out.printf("Selecione uma cidade: 1 - São Paulo ou 2 - Osasco %n");
                cidade = input.nextInt();
                input.nextLine();

                if(cidade == 1){
                    System.out.printf("São Paulo %n Sua população é de aproximadamente 12,33 milhões de habitantes. %n Com IDH de 0,805 %n");
                    System.out.printf("Suas festas incluem: Festa de Nossa Senhora de Achiropita, Festa italiana de rua e Festival das Estrelas, entre outros%n");
                    System.out.printf("Pontos turisticos: Galeria do Rock, MASP, Catedral da Sé, entre outros.");
                }
                else if(cidade == 2){
                    System.out.printf("Osasco %n Sua população é de aproximadamente 699.944 habitantes. %n Com IDH de 0,776 %n");
                    System.out.printf("Sua festa popular: Festa de Santo Antônio %n");
                    System.out.printf("Pontos turisticos: Parque Chico Mendes, Ponte Metalica, Museu Dimitri Sensaud de Lavaud, entre outros.");
                }
                else{
                    System.out.printf("Cidade inexistente");
                }
                break;
            case 3:
                System.out.printf("Selecione uma cidade: 1 - Salvador ou 2 - Porto Seguro %n");
                cidade = input.nextInt();
                input.nextLine();

                if(cidade == 1){
                    System.out.printf("Salvador %n Sua população é de aproximadamente 2.900.319 habitantes. %n Com IDH de 0,670 %n");
                    System.out.printf("Sua festa popular é a festa de Santa Bárbara %n");
                    System.out.printf("Pontos turisticos: Farol da Barra, Elevador Lacerda, entre outros");
                }
                else if(cidade == 2){
                    System.out.printf("Porto Seguro %n Sua população é de aproximadamente 150.658 habitantes. %n Com IDH de 0,676 %n");
                    System.out.printf("Sua festa popular é a festa de São Sebastião %n");
                    System.out.printf("Pontos turisticos: Trancoso, Passarela do Descobrimento, Centro Histórico entre outros.");
                }
                else{
                    System.out.printf("Cidade inexistente");
                }
                break;
            default:
                System.out.printf("Número selecionado inexistente");
                break;
        }

    }

}
