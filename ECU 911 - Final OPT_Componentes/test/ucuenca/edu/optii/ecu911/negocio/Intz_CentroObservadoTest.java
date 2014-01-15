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
       
    }

    /**
     * Test of notificar method, of class Intz_CentroObservado.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        Intz_CentroObservado instance = new Intz_CentroObservadoImpl();
        String expResult = "";
        String result = instance.notificar();
        assertEquals(expResult, result);
        
    }

    public class Intz_CentroObservadoImpl implements Intz_CentroObservado {

        public void agregarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
        }

        public void eliminarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
        }

        public String notificar() {
            return "";
        }
    }
}
