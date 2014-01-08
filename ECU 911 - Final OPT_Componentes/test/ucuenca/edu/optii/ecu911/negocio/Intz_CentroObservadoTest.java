/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucuenca.edu.optii.ecu911.negocio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cuent
 */
public class Intz_CentroObservadoTest {
    
    public Intz_CentroObservadoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of agregarEntidadObservadora method, of class Intz_CentroObservado.
     */
    @Test
    public void testAgregarEntidadObservadora() {
        System.out.println("agregarEntidadObservadora");
        Intz_EntidadCooperativa_Observador mientidad = null;
        Intz_CentroObservado instance = new Intz_CentroObservadoImpl();
        instance.agregarEntidadObservadora(mientidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarEntidadObservadora method, of class Intz_CentroObservado.
     */
    @Test
    public void testEliminarEntidadObservadora() {
        System.out.println("eliminarEntidadObservadora");
        Intz_EntidadCooperativa_Observador mientidad = null;
        Intz_CentroObservado instance = new Intz_CentroObservadoImpl();
        instance.eliminarEntidadObservadora(mientidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notificar method, of class Intz_CentroObservado.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        String incidente = "";
        Intz_CentroObservado instance = new Intz_CentroObservadoImpl();
        String expResult = "";
        String result = instance.notificar(incidente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    public class Intz_CentroObservadoImpl implements Intz_CentroObservado {

        public void agregarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
        }

        public void eliminarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
        }

        public String notificar(String incidente) {
            return "";
        }
    }
    
}
