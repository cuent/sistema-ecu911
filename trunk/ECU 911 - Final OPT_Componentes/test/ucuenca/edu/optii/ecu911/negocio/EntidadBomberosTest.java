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
public class EntidadBomberosTest {
    
    public EntidadBomberosTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recibir_alarma method, of class EntidadBomberos.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        EntidadBomberos instance = new EntidadBomberos();
        String expResult = "Bomberos en camino...";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of aceptar method, of class EntidadBomberos.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = null ;
        EntidadBomberos instance = new EntidadBomberos();
    }

    /**
     * Test of getNombre method, of class EntidadBomberos.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        EntidadBomberos instance = new EntidadBomberos();
        String expResult = "Bomberos";
        String result = instance.getNombre();
        assertEquals(expResult, result);
       
    }
}
