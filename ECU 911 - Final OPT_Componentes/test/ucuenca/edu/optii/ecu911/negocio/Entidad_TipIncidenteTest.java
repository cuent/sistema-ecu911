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
public class Entidad_TipIncidenteTest {
    
    public Entidad_TipIncidenteTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMientidad method, of class Entidad_TipIncidente.
     */
    @Test
    public void testGetMientidad() {
        System.out.println("getMientidad");
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.getMientidad();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of setMientidad method, of class Entidad_TipIncidente.
     */
    @Test
    public void testSetMientidad() {
        System.out.println("setMientidad");
        EntidadCooperativa mientidad = null;
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        instance.setMientidad(mientidad);

    }

    /**
     * Test of getMiTipoIn method, of class Entidad_TipIncidente.
     */
    @Test
    public void testGetMiTipoIn() {
        System.out.println("getMiTipoIn");
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        TipoIncidente expResult = null;
        TipoIncidente result = instance.getMiTipoIn();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setMiTipoIn method, of class Entidad_TipIncidente.
     */
    @Test
    public void testSetMiTipoIn() {
        System.out.println("setMiTipoIn");
        TipoIncidente miTipoIn = null;
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        instance.setMiTipoIn(miTipoIn);
        
    }

    /**
     * Test of grabar method, of class Entidad_TipIncidente.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        int inc = 0;
        int ent = 0;
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        boolean expResult = false;
        boolean result = instance.grabar(inc, ent);
        assertEquals(expResult, result);
        
    }
}
