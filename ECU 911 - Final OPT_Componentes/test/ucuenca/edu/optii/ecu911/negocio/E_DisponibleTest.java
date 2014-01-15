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
public class E_DisponibleTest {
    
    public E_DisponibleTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SuspenderTelefono method, of class E_Disponible.
     */
    @Test
    public void testSuspenderTelefono() {
        System.out.println("SuspenderTelefono");
        Telefono tel = null;
        E_Disponible instance = new E_Disponible();
        instance.SuspenderTelefono(tel);
    }

    /**
     * Test of OcuparTelefono method, of class E_Disponible.
     */
    @Test
    public void testOcuparTelefono() {
        System.out.println("OcuparTelefono");
        Telefono tel = null;
        E_Disponible instance = new E_Disponible();
        instance.OcuparTelefono(tel);
    }

    /**
     * Test of EsperarTelefono method, of class E_Disponible.
     */
    @Test
    public void testEsperarTelefono() {
        System.out.println("EsperarTelefono");
        Telefono tel = null;
        E_Disponible instance = new E_Disponible();
        instance.EsperarTelefono(tel);
    }

    /**
     * Test of LiberarTelefono method, of class E_Disponible.
     */
    @Test
    public void testLiberarTelefono() {
        System.out.println("LiberarTelefono");
        Telefono tel = null;
        E_Disponible instance = new E_Disponible();
        instance.LiberarTelefono(tel);
    
    }
}
