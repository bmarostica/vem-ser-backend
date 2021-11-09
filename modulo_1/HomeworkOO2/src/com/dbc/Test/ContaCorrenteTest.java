package com.dbc.Test;

import com.dbc.ContaCorrente;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaCorrenteTest {

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoCOmSucesso(){
        //Arrange
        ContaCorrente joseCorrente = new ContaCorrente();
        joseCorrente.setSaldo(1500.00);
        joseCorrente.setChequeEspecial(1000.00);

        //Act
        Boolean sacar = joseCorrente.sacar(300.00);
        Double saldo = joseCorrente.getSaldo();

        //Assert
        assertTrue(sacar);
        assertEquals(1200, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo(){
        //Arrange
        ContaCorrente joseCorrente = new ContaCorrente();
        joseCorrente.setSaldo(1500.00);
        joseCorrente.setChequeEspecial(1000.00);

        //Act
        Boolean sacar = joseCorrente.sacar(3000.00);
        Double saldo = joseCorrente.getSaldo();

        //Assert
        assertFalse(sacar);
        assertEquals(1500, saldo, 0);
    }
}
