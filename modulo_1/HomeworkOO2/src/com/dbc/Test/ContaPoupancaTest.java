package com.dbc.Test;

import com.dbc.ContaPoupanca;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaPoupancaTest {

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){
        //Arrange
        ContaPoupanca josePoupanca = new ContaPoupanca();
        josePoupanca.setSaldo(1500.00);
        josePoupanca.creditarTaxa();

        //Act
        Boolean sacar = josePoupanca.sacar(300.00);
        Double saldo = josePoupanca.getSaldo();

        //Assert
        assertTrue(sacar);
        assertEquals(1215, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo(){
        //Arrange
        ContaPoupanca josePoupanca = new ContaPoupanca();
        josePoupanca.setSaldo(1500.00);

        //Act
        Boolean sacar = josePoupanca.sacar(3000.00);
        Double saldo = josePoupanca.getSaldo();

        //Assert
        assertFalse(sacar);
        assertEquals(1500, saldo, 0);
    }
}
