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
public class Intz_EntidadCooperativa_ObservadorTest {
    
    public Intz_EntidadCooperativa_ObservadorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recibir_info method, of class Intz_EntidadCooperativa_Observador.
     */
    @Test
    public void testRecibir_info() {
        System.out.println("recibir_info");
        Intz_EntidadCooperativa_Observador instance = new Intz_EntidadCooperativa_ObservadorImpl();
        instance.recibir_info();
   
    }

    /**
     * Test of recibir_alarma method, of class Intz_EntidadCooperativa_Observador.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        Intz_EntidadCooperativa_Observador instance = new Intz_EntidadCooperativa_ObservadorImpl();
        String expResult = "";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of generar_reportes_incidente method, of class Intz_EntidadCooperativa_Observador.
     */
    @Test
    public void testGenerar_reportes_incidente() {
        System.out.println("generar_reportes_incidente");
        Intz_EntidadCooperativa_Observador instance = new Intz_EntidadCooperativa_ObservadorImpl();
        instance.generar_reportes_incidente();
        
    }

    /**
     * Test of actualizar method, of class Intz_EntidadCooperativa_Observador.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Intz_EntidadCooperativa_Observador instance = new Intz_EntidadCooperativa_ObservadorImpl();
        instance.actualizar();
   
    }

    public class Intz_EntidadCooperativa_ObservadorImpl implements Intz_EntidadCooperativa_Observador {

        public void recibir_info() {
        }

        public String recibir_alarma() {
            return "";
        }

        public void generar_reportes_incidente() {
        }

        public void actualizar() {
        }
    }
}
