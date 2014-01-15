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
public class Servicio_CentroEcuTest {
    
    public Servicio_CentroEcuTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMiservicio method, of class Servicio_CentroEcu.
     */
    @Test
    public void testGetMiservicio() {
        System.out.println("getMiservicio");
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        Servicio expResult = null;
        Servicio result = instance.getMiservicio();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMiservicio method, of class Servicio_CentroEcu.
     */
    @Test
    public void testSetMiservicio() {
        System.out.println("setMiservicio");
        Servicio miservicio = null;
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        instance.setMiservicio(miservicio);
      
    }

    /**
     * Test of getMicentro method, of class Servicio_CentroEcu.
     */
    @Test
    public void testGetMicentro() {
        System.out.println("getMicentro");
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        CentroEcu_Observado expResult = null;
        CentroEcu_Observado result = instance.getMicentro();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMicentro method, of class Servicio_CentroEcu.
     */
    @Test
    public void testSetMicentro() {
        System.out.println("setMicentro");
        CentroEcu_Observado micentro = null;
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        instance.setMicentro(micentro);
        
    }
}
