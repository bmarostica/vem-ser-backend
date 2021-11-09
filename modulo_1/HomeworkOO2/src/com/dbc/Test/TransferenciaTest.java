package com.dbc.Test;

import com.dbc.ContaCorrente;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferenciaTest {

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        //Arrange
        ContaCorrente mariaCorrente = new ContaCorrente();
        ContaCorrente joseCorrente = new ContaCorrente();
        joseCorrente.setSaldo(1500.00);
        mariaCorrente.setSaldo(1000.00);
        joseCorrente.setChequeEspecial(0.0);
        mariaCorrente.setChequeEspecial(100.00);

        //Act
        Boolean transferir = joseCorrente.transferir(mariaCorrente, 300.00);
        Double transferencia = mariaCorrente.getSaldo();

        //Assert
        assertTrue(transferir);
        assertEquals(1300, transferencia, 0);
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoSemSucesso(){
        //Arrange
        ContaCorrente mariaCorrente = new ContaCorrente();
        ContaCorrente joseCorrente = new ContaCorrente();
        joseCorrente.setSaldo(1500.00);
        mariaCorrente.setSaldo(1000.00);
        joseCorrente.setChequeEspecial(0.0);
        mariaCorrente.setChequeEspecial(100.00);

        //Act
        Boolean transferir = joseCorrente.transferir(mariaCorrente, 5000.00);
        Double transferencia = mariaCorrente.getSaldo();

        //Assert
        assertFalse(transferir);
        assertEquals(1000.00, transferencia, 0);
    }
}
