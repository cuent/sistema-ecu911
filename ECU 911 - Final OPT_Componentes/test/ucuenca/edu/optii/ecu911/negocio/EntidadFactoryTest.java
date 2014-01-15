/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class EntidadFactoryTest {
    
    public EntidadFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearEntidad method, of class EntidadFactory.
     */
    @Test
    public void testCrearEntidad() {
        System.out.println("crearEntidad");
        String tipo = "";
        EntidadFactory instance = new EntidadFactory();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.crearEntidad(tipo);
        assertEquals(expResult, result);
      
    }
}
