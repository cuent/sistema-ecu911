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
public class E_OcupadoTest {
    
    public E_OcupadoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SuspenderTelefono method, of class E_Ocupado.
     */
    @Test
    public void testSuspenderTelefono() {
        System.out.println("SuspenderTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        instance.SuspenderTelefono(tel);
        
    }

    /**
     * Test of OcuparTelefono method, of class E_Ocupado.
     */
    @Test
    public void testOcuparTelefono() {
        System.out.println("OcuparTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        instance.OcuparTelefono(tel);
       
    }

    /**
     * Test of EsperarTelefono method, of class E_Ocupado.
     */
    @Test
    public void testEsperarTelefono() {
        System.out.println("EsperarTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        instance.EsperarTelefono(tel);
       
    }

    /**
     * Test of LiberarTelefono method, of class E_Ocupado.
     */
    @Test
    public void testLiberarTelefono() {
        System.out.println("LiberarTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        instance.LiberarTelefono(tel);
      
    }
}
