package com.dbc;

public class Main {

    public static void main(String[] args) {
        Contato joseContato1 = new Contato();
        joseContato1.descricao = "AA";
        joseContato1.telefone = "5184986564";
        joseContato1.tipo = 1;

        Contato joseContato2 = new Contato();
        joseContato2.descricao = "AC";
        joseContato2.telefone = "3468465211";
        joseContato2.tipo = 2;

        /*Endereco joseEndereco1 = new Endereco();
        joseEndereco1.tipo = 1;
        joseEndereco1.logradouro = "Rua Getulio Vargas";
        joseEndereco1.numero = 868;
        joseEndereco1.complemento = "casa";
        joseEndereco1.cep = "98667894696";
        joseEndereco1.cidade = "Porto Alegre";
        joseEndereco1.estado = "RS";
        joseEndereco1.pais = "BR";*/

        Endereco joseEndereco2 = new Endereco();
        joseEndereco2.tipo = 2;
        joseEndereco2.logradouro = "Rua Pasqualine";
        joseEndereco2.numero = 9836;
        joseEndereco2.complemento = "Prédio";
        joseEndereco2.cep = "3518354932";
        joseEndereco2.cidade = "Porto Alegre";
        joseEndereco2.estado = "RS";
        joseEndereco2.pais = "BR";

        Cliente joseCliente = new Cliente();
        joseCliente.nome = "José Alvarez";
        joseCliente.cpf = "348964328-78";
        //joseCliente.enderecos[0] = joseEndereco1;
        joseCliente.enderecos[1] = joseEndereco2;
        joseCliente.contatos[0] = joseContato1;
        joseCliente.contatos[1] = joseContato2;

        ContaCorrente joseConta = new ContaCorrente();
        joseConta.cliente = joseCliente;
        joseConta.numeroConta = "587931-3";
        joseConta.agencia = 158;
        joseConta.saldo = 895.5;
        joseConta.chequeEspecial = 1500.0;

        Contato mariaContato1 = new Contato();
        mariaContato1.descricao = "AC";
        mariaContato1.telefone = "896486511";
        mariaContato1.tipo = 1;

        Contato mariaContato2 = new Contato();
        mariaContato2.descricao = "AC";
        mariaContato2.telefone = "3489645315";
        mariaContato2.tipo = 1;

        Endereco mariaEndereco1 = new Endereco();
        mariaEndereco1.tipo = 1;
        mariaEndereco1.logradouro = "Rua Maribel";
        mariaEndereco1.numero = 93;
        mariaEndereco1.complemento = "casa";
        mariaEndereco1.cep = "6489131";
        mariaEndereco1.cidade = "Caxias do Sul";
        mariaEndereco1.estado = "RS";
        mariaEndereco1.pais = "BR";

        Endereco mariaEndereco2 = new Endereco();
        mariaEndereco2.tipo = 2;
        mariaEndereco2.logradouro = "Rua André Poente";
        mariaEndereco2.numero = 427;
        mariaEndereco2.complemento = "casa";
        mariaEndereco2.cep = "15684";
        mariaEndereco2.cidade = "Alvorada";
        mariaEndereco2.estado = "RS";
        mariaEndereco2.pais = "BR";

        Cliente mariaCliente = new Cliente();
        mariaCliente.nome = "Maria Leitão";
        mariaCliente.cpf = "45684321";
        mariaCliente.enderecos[0] = mariaEndereco1;
        mariaCliente.enderecos[1] = mariaEndereco2;
        mariaCliente.contatos[0] = mariaContato1;
        mariaCliente.contatos[1] = mariaContato2;

        ContaCorrente mariaConta = new ContaCorrente();
        mariaConta.cliente = mariaCliente;
        mariaConta.numeroConta = "36486-2";
        mariaConta.agencia = 98;
        mariaConta.saldo = 215.79;
        mariaConta.chequeEspecial = 0.0;

        joseCliente.imprimirCliente();
        mariaCliente.imprimirCliente();

        mariaConta.sacar(100.00);
        joseConta.sacar(30000.00);

        joseConta.transferir(mariaConta, 130.00);
        mariaConta.transferir(joseConta, 118.20);

        joseConta.imprimirContaCorrente();
        mariaConta.imprimirContaCorrente();

        Cliente cliente = new Cliente("João", "45468", "con", "")

    }
}
