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
public class EntidadFactoryMethodTest {
    
    public EntidadFactoryMethodTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearEntidad method, of class EntidadFactoryMethod.
     */
    @Test
    public void testCrearEntidad() {
        System.out.println("crearEntidad");
        String tipo = "";
        EntidadFactoryMethod instance = new EntidadFactoryMethodImpl();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.crearEntidad(tipo);
        assertEquals(expResult, result);
       
    }

    public class EntidadFactoryMethodImpl implements EntidadFactoryMethod {

        public EntidadCooperativa crearEntidad(String tipo) {
            return null;
        }
    }
}
