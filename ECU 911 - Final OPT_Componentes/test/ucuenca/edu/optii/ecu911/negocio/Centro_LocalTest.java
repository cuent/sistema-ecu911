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
public class Centro_LocalTest {
    String expResult = "Cuenca";
        
    public Centro_LocalTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class Centro_Local.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Centro_Local instance = new Centro_Local();
        instance.nombre="Cuenca";
        String result = instance.nombre;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of notificar method, of class Centro_Local.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        Centro_Local instance = new Centro_Local();
        String expResult = null;
        String result = instance.notificar();
        
    }
}
