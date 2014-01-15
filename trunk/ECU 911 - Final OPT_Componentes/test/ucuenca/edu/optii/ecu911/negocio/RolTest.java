/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class RolTest {
    
    public RolTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMispermisos method, of class Rol.
     */
    @Test
    public void testGetMispermisos() {
        System.out.println("getMispermisos");
        Rol instance = new Rol();
        List expResult = null;
        List result = instance.getMispermisos();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMispermisos method, of class Rol.
     */
    @Test
    public void testSetMispermisos() {
        System.out.println("setMispermisos");
        List<Permiso> mispermisos = null;
        Rol instance = new Rol();
        instance.setMispermisos(mispermisos);
       ;
    }

    /**
     * Test of getId method, of class Rol.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Rol instance = new Rol();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Rol.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Rol instance = new Rol();
        instance.setId(id);
        
    }

    /**
     * Test of getDescripcion method, of class Rol.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Rol instance = new Rol();
        instance.descripcion = "admin1";
        String result = instance.getDescripcion();
        assertEquals("admin1", result);
      
    }

    /**
     * Test of setDescripcion method, of class Rol.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Rol instance = new Rol();
        instance.setDescripcion(descripcion);
        
    }

    /**
     * Test of grabar method, of class Rol.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Rol instance = new Rol();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of buscarIde method, of class Rol.
     */
    @Test
    public void testBuscarIde() {
        System.out.println("buscarIde");
        Rol instance = new Rol();
        boolean expResult = false;
        boolean result = instance.buscarIde();
        assertEquals(expResult, result);
        
    }
}
