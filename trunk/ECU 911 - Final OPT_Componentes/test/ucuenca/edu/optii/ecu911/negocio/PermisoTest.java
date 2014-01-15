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
public class PermisoTest {
    
    public PermisoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Permiso.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Permiso instance = new Permiso();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setId method, of class Permiso.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Permiso instance = new Permiso();
        instance.setId(id);
       
    }

    /**
     * Test of getDescripcion method, of class Permiso.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Permiso instance = new Permiso();
     instance.descripcion="listados";
        String result = instance.getDescripcion();
        assertEquals("listados", result);
       
    }

    /**
     * Test of setDescripcion method, of class Permiso.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Permiso instance = new Permiso();
        instance.setDescripcion(descripcion);
       
    }

    /**
     * Test of grabar method, of class Permiso.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Permiso instance = new Permiso();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of buscarDescripcion method, of class Permiso.
     */
    @Test
    public void testBuscarDescripcion() {
        System.out.println("buscarDescripcion");
        Permiso instance = new Permiso();
        boolean expResult = false;
        boolean result = instance.buscarDescripcion();
        assertEquals(expResult, result);
     
    }
}
