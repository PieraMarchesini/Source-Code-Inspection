/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Piera
 */
public class TicketMachineTest {
    private TicketMachine tm;
    public TicketMachineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tm = new TicketMachine(10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class TicketMachine.
     */
    @Test
    public void testInserirPassa() throws Exception {
        tm.inserir(2);
        assertEquals(2, tm.getSaldo());
    }
    
    @Test
    public void testInserirPassa2() throws Exception {
        tm.inserir(5);
        assertEquals(5, tm.getSaldo());
    }
    
    @Test
    public void testInserirPassa3() throws Exception {
        tm.inserir(10);
        assertEquals(10, tm.getSaldo());
    }
    
    @Test
    public void testInserirPassa4() throws Exception {
        tm.inserir(20);
        assertEquals(20, tm.getSaldo());
    }
    
    @Test
    public void testInserirPassa5() throws Exception {
        tm.inserir(50);
        assertEquals(50, tm.getSaldo());
    }
    
    @Test
    public void testInserirPassa6() throws Exception {
        tm.inserir(100);
        assertEquals(100, tm.getSaldo());
    }
    
    @Test (expected = PapelMoedaInvalidaException.class)
    public void testInserirFalha() throws Exception {
        tm.inserir(3);
        assertEquals(3, tm.getSaldo());
    }
    

    /**
     * Test of getSaldo method, of class TicketMachine.
     */
    @Test
    public void testGetSaldoPassa() throws PapelMoedaInvalidaException {
        tm.inserir(5);
        assertEquals(5, tm.getSaldo());
    }
    
    @Test (expected = PapelMoedaInvalidaException.class)
    public void testGetSaldoFalha() throws PapelMoedaInvalidaException {
        tm.inserir(6);
        assertEquals(6, tm.getSaldo());
    }

    /**
     * Test of getTroco method, of class TicketMachine.
     */
    @Test
    public void testGetTrocoDeveriaPassar() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        tm.inserir(20);
        tm.imprimir();
        assertEquals(10, tm.getTroco());
    }
    
    @Test(expected = PapelMoedaInvalidaException.class)
    public void testGetTrocoFalha() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        tm.inserir(11);
        tm.imprimir();
        assertEquals(1, tm.getTroco());
    }

    /**
     * Test of imprimir method, of class TicketMachine.
     */
    @Test(expected = SaldoInsuficienteException.class)
    public void testImprimirFalha() throws Exception {
        tm.inserir(5);
        tm.imprimir();
        assertEquals(-5, tm.getSaldo());
    }
    
    
    @Test
    public void testImprimirDeveriaPassar() throws Exception {
        tm.inserir(10);
        tm.imprimir();
        assertEquals(0, tm.getSaldo());
    }
   
}
