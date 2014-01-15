/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class TipoIncidenteTest {
    
    public TipoIncidenteTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMisentidades method, of class TipoIncidente.
     */
    @Test
    public void testGetMisentidades() {
        System.out.println("getMisentidades");
        TipoIncidente instance = new TipoIncidente();
        List expResult = null;
        List result = instance.getMisentidades();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setMisentidades method, of class TipoIncidente.
     */
    @Test
    public void testSetMisentidades() {
        System.out.println("setMisentidades");
        List<EntidadCooperativa> misentidades = null;
        TipoIncidente instance = new TipoIncidente();
        instance.setMisentidades(misentidades);
       
    }

    /**
     * Test of getId method, of class TipoIncidente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TipoIncidente instance = new TipoIncidente();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setId method, of class TipoIncidente.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        TipoIncidente instance = new TipoIncidente();
        instance.setId(id);
       
    }

    /**
     * Test of getDescripcion method, of class TipoIncidente.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        TipoIncidente instance = new TipoIncidente();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setDescripcion method, of class TipoIncidente.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        TipoIncidente instance = new TipoIncidente();
        instance.setDescripcion(descripcion);
        
    }

    /**
     * Test of grabar method, of class TipoIncidente.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        TipoIncidente instance = new TipoIncidente();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of listar method, of class TipoIncidente.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        String ciudad = "";
        String descripcion = "";
        TipoIncidente instance = new TipoIncidente();
        ArrayList expResult = null;
        ArrayList result = instance.listar(ciudad, descripcion);
        assertEquals(expResult, result);

    }

    /**
     * Test of buscarDescripcion method, of class TipoIncidente.
     */
    @Test
    public void testBuscarDescripcion() {
        System.out.println("buscarDescripcion");
        TipoIncidente instance = new TipoIncidente();
        boolean expResult = false;
        boolean result = instance.buscarDescripcion();
        assertEquals(expResult, result);
       
    }
}
