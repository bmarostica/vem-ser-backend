package com.dbc.Test;

import com.dbc.ContaPagamento;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContaPagamentoTest {

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoCOmSucesso(){
        //Arrange
        ContaPagamento josePagamento = new ContaPagamento();
        josePagamento.setSaldo(1500.00);

        //Act
        Boolean sacar = josePagamento.sacar(300.00);
        Double saldo = josePagamento.getSaldo();

        //Assert
        assertTrue(sacar);
        assertEquals(1195.75, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){
        //Arrange
        ContaPagamento josePagamento = new ContaPagamento();
        josePagamento.setSaldo(1500.00);

        //Act
        Boolean sacar = josePagamento.sacar(3000.00);
        Double saldo = josePagamento.getSaldo();

        //Assert
        assertFalse(sacar);
        assertEquals(1500, saldo, 0);
    }
}
