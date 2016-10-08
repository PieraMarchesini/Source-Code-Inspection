/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

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
public class PapelMoedaTest {
    private PapelMoeda pm;
    
    public PapelMoedaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getValor method, of class PapelMoeda.
     */
    @Test
    public void testGetValorPassa() {
        pm = new PapelMoeda(10, 3);
        assertEquals(10, pm.getValor());
    }
    
    @Test
    public void testGetValorFalha() {
        pm = new PapelMoeda(20, 3);
        assertEquals(10, pm.getValor());
    }
    
}
