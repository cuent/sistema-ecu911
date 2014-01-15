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
public class Centro_NacionalTest {
    String expResult = "Riobamba";
    public Centro_NacionalTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class Centro_Nacional.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Centro_Nacional instance = new Centro_Nacional();
        instance.nombre="Riobamba";
        String result = instance.nombre;
        assertEquals(expResult, result);
       
    }

    /**
     * Test of notificar method, of class Centro_Nacional.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        Centro_Nacional instance = new Centro_Nacional();
        String result = instance.notificar();  
    }
}
