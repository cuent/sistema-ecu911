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
public class EntidadCNTTest {
    
    public EntidadCNTTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recibir_alarma method, of class EntidadCNT.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        EntidadCNT instance = new EntidadCNT();
        String expResult = "CNT en camino...";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of aceptar method, of class EntidadCNT.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = null;
        EntidadCNT instance = new EntidadCNT();
        instance.setId(10) ;
        String expResult = "";
       // String result = instance.aceptar(visitor);
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of getNombre method, of class EntidadCNT.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        EntidadCNT instance = new EntidadCNT();
        String expResult = "CNT";
        String result = instance.getNombre();
        assertEquals(expResult, result);
       
    }
}
