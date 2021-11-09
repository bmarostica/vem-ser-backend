package com.dbc;

public class Main {

    public static void main(String[] args) {
        Contato joseContato1 = new Contato();
        joseContato1.setTipo(1);
        joseContato1.setDescricao("Casa");
        joseContato1.setTelefone("(51)98769-7632");

        Contato joseContato2 = new Contato();
        joseContato2.setTipo(2);
        joseContato2.setDescricao("Trabalho");
        joseContato2.setTelefone("(51)3483-7632");

        Endereco joseEndereco1 = new Endereco();
        joseEndereco1.setTipo(1);
        joseEndereco1.setCep("94658751");
        joseEndereco1.setLogradouro("Rua Getulio Vargas");
        joseEndereco1.setNumero(486);
        joseEndereco1.setComplemento("Apartamento, 35");
        joseEndereco1.setCidade("Alvorada");
        joseEndereco1.setEstado("RS");
        joseEndereco1.setPais("Brasil");

        Cliente jose = new Cliente();
        jose.setNome("Jose Alves");
        jose.setCpf("85631567854");
        jose.getContatos()[0] = joseContato1;
        jose.getContatos()[1] = joseContato2;
        jose.getEnderecos()[0] = joseEndereco1;

        ContaPagamento josePagamento = new ContaPagamento();
        josePagamento.setAgencia("4864");
        josePagamento.setCliente(jose);
        josePagamento.setNumeroConta("486513-4");
        josePagamento.setSaldo(600.00);

        ContaCorrente joseCorrente = new ContaCorrente();
        joseCorrente.setCliente(jose);
        joseCorrente.setAgencia("1548");
        joseCorrente.setNumeroConta("18431-3");
        joseCorrente.setSaldo(900.00);
        joseCorrente.setChequeEspecial(300.00);

        Contato mariaContato1 = new Contato();
        mariaContato1.setTipo(1);
        mariaContato1.setDescricao("Casa");
        mariaContato1.setTelefone("(51)3442-7632");

        Endereco mariaEndereco1 = new Endereco();
        mariaEndereco1.setTipo(1);
        mariaEndereco1.setCep("65189846");
        mariaEndereco1.setLogradouro("Rua Maris e Barros");
        mariaEndereco1.setNumero(348);
        mariaEndereco1.setComplemento("casa");
        mariaEndereco1.setCidade("Alvorada");
        mariaEndereco1.setEstado("RS");
        mariaEndereco1.setPais("Brasil");

        Cliente maria = new Cliente();
        maria.setNome("Maria Joaquina");
        maria.setCpf("3116518461");
        maria.getContatos()[0] = mariaContato1;
        maria.getEnderecos()[0] = mariaEndereco1;

        ContaPoupanca mariaPoupanca = new ContaPoupanca();
        mariaPoupanca.setAgencia("564684");
        mariaPoupanca.setNumeroConta("8435-3");
        mariaPoupanca.setSaldo(1000.00);
        mariaPoupanca.setCliente(maria);


        jose.imprimirCliente();

        josePagamento.transferir(mariaPoupanca, 300.00);
        josePagamento.sacar(850.00);
        josePagamento.imprimir();

        maria.imprimirCliente();

        mariaPoupanca.depositar(250.00);
        mariaPoupanca.creditarTaxa();
        mariaPoupanca.imprimir();






    }
}
