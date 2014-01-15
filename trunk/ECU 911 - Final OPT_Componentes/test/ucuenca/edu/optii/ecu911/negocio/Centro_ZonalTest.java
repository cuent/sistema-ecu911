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
public class Centro_ZonalTest {
    String expResult = "Gualaceo";
        
    public Centro_ZonalTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class Centro_Zonal.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Centro_Zonal instance = new Centro_Zonal();
        instance.nombre="Gualaceo";
        String result = instance.nombre;
        assertEquals(expResult, result);
   
    }

    /**
     * Test of notificar method, of class Centro_Zonal.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        Centro_Zonal instance = new Centro_Zonal();
        String result = instance.notificar();
        
    }
}
