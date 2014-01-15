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
public class Operador_EntidadCTest {
    
    public Operador_EntidadCTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCorreo_el method, of class Operador_EntidadC.
     */
    @Test
    public void testGetCorreo_el() {
        System.out.println("getCorreo_el");
        Operador_EntidadC instance = new Operador_EntidadC();
        String expResult = "";
        String result = instance.getCorreo_el();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCorreo_el method, of class Operador_EntidadC.
     */
    @Test
    public void testSetCorreo_el() {
        System.out.println("setCorreo_el");
        String correo_el = "";
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.setCorreo_el(correo_el);
       
    }

    /**
     * Test of getSueldo method, of class Operador_EntidadC.
     */
    @Test
    public void testGetSueldo() {
        System.out.println("getSueldo");
        Operador_EntidadC instance = new Operador_EntidadC();
        double expResult = 0.0;
        double result = instance.getSueldo();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setSueldo method, of class Operador_EntidadC.
     */
    @Test
    public void testSetSueldo() {
        System.out.println("setSueldo");
        double sueldo = 0.0;
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.setSueldo(sueldo);

    }

    /**
     * Test of getMientidad method, of class Operador_EntidadC.
     */
    @Test
    public void testGetMientidad() {
        System.out.println("getMientidad");
        Operador_EntidadC instance = new Operador_EntidadC();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.getMientidad();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of setMientidad method, of class Operador_EntidadC.
     */
    @Test
    public void testSetMientidad() {
        System.out.println("setMientidad");
        EntidadCooperativa mientidad = null;
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.setMientidad(mientidad);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of grabar method, of class Operador_EntidadC.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Operador_EntidadC instance = new Operador_EntidadC();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
       
    }
}
