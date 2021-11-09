package com.dbc.Test;

import com.dbc.ContaPagamento;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DepositTest {

    @Test
    public void deveTestarDepositoEVerificarSaldoCOmSucesso(){
        //Arrange
        ContaPagamento josePagamento = new ContaPagamento();
        josePagamento.setSaldo(1500.00);

        //Act
        Boolean deposito = josePagamento.depositar(300.00);
        Double depositar = josePagamento.getSaldo();

        //Assert
        assertTrue(deposito);
        assertEquals(1800.00, depositar, 0);
    }

    @Test
    public void deveTestarDepositoNegativo(){
        //Arrange
        ContaPagamento josePagamento = new ContaPagamento();
        josePagamento.setSaldo(1500.00);

        //Act
        Boolean deposito = josePagamento.sacar(-650.00);
        Double depositar = josePagamento.getSaldo();

        //Assert
        assertFalse(deposito);
        assertEquals(1500, depositar, 0);
    }
}
