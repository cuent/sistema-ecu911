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
public class Ubicacion_IncidenteTest {
    
    public Ubicacion_IncidenteTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMitipo method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetMitipo() {
        System.out.println("getMitipo");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        TipoIncidente expResult = null;
        TipoIncidente result = instance.getMitipo();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMitipo method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetMitipo() {
        System.out.println("setMitipo");
        TipoIncidente mitipo = null;
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setMitipo(mitipo);
       
    }

    /**
     * Test of getCalle_principal method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetCalle_principal() {
        System.out.println("getCalle_principal");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        String expResult = "";
        String result = instance.getCalle_principal();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCalle_principal method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetCalle_principal() {
        System.out.println("setCalle_principal");
        String calle_principal = "";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setCalle_principal(calle_principal);
     
    }

    /**
     * Test of getInterseccion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetInterseccion() {
        System.out.println("getInterseccion");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        String expResult = "";
        String result = instance.getInterseccion();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setInterseccion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetInterseccion() {
        System.out.println("setInterseccion");
        String interseccion = "";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setInterseccion(interseccion);

    }

    /**
     * Test of getReferencia_ubicacion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetReferencia_ubicacion() {
        System.out.println("getReferencia_ubicacion");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        String expResult = "";
        String result = instance.getReferencia_ubicacion();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setReferencia_ubicacion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetReferencia_ubicacion() {
        System.out.println("setReferencia_ubicacion");
        String referencia_ubicacion = "";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setReferencia_ubicacion(referencia_ubicacion);
     
    }

    /**
     * Test of getCiudad method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        String expResult = "";
        String result = instance.getCiudad();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of setCiudad method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetCiudad() {
        System.out.println("setCiudad");
        String ciudad = "";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setCiudad(ciudad);
       
    }

    /**
     * Test of grabar method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
       
    }
}
