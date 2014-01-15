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
public class TelefonoTest {
    
    public TelefonoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of EstablecerEstado method, of class Telefono.
     */
    @Test
    public void testEstablecerEstado() {
        System.out.println("EstablecerEstado");
        Intz_EstadosTelefono es = null;
        Telefono instance = new Telefono();
        instance.EstablecerEstado(es);
    
    }

    /**
     * Test of SuspenderTelefono method, of class Telefono.
     */
    @Test
    public void testSuspenderTelefono() {
        System.out.println("SuspenderTelefono");
        Telefono instance = new Telefono();
        instance.SuspenderTelefono();
       
    }

    /**
     * Test of OcuparTelefono method, of class Telefono.
     */
    @Test
    public void testOcuparTelefono() {
        System.out.println("OcuparTelefono");
        Telefono instance = new Telefono();
        instance.OcuparTelefono();
       
    }

    /**
     * Test of EsperarTelefono method, of class Telefono.
     */
    @Test
    public void testEsperarTelefono() {
        System.out.println("EsperarTelefono");
        Telefono instance = new Telefono();
        instance.EsperarTelefono();
       
    }

    /**
     * Test of LiberarTelefono method, of class Telefono.
     */
    @Test
    public void testLiberarTelefono() {
        System.out.println("LiberarTelefono");
        Telefono instance = new Telefono();
        instance.LiberarTelefono();
       
    }

    /**
     * Test of getId method, of class Telefono.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Telefono instance = new Telefono();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Telefono.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Telefono instance = new Telefono();
        instance.setId(id);
       
    }

    /**
     * Test of getTipo method, of class Telefono.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Telefono instance = new Telefono();
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setTipo method, of class Telefono.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        Telefono instance = new Telefono();
        instance.setTipo(tipo);
  
    }

    /**
     * Test of getNumero method, of class Telefono.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Telefono instance = new Telefono();
        String expResult = "";
        String result = instance.getNumero();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNumero method, of class Telefono.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "";
        Telefono instance = new Telefono();
        instance.setNumero(numero);

    }

    /**
     * Test of grabar method, of class Telefono.
     */
    @Test
    public void testGrabar() throws Exception {
        System.out.println("grabar");
        Telefono instance = new Telefono();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of buscarNumeroSegunIde method, of class Telefono.
     */
    @Test
    public void testBuscarNumeroSegunIde() {
        System.out.println("buscarNumeroSegunIde");
        Telefono instance = new Telefono();
        boolean expResult = false;
        boolean result = instance.buscarNumeroSegunIde();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of buscarNumero method, of class Telefono.
     */
    @Test
    public void testBuscarNumero() {
        System.out.println("buscarNumero");
        Telefono instance = new Telefono();
        boolean expResult = false;
        boolean result = instance.buscarNumero();
        assertEquals(expResult, result);
       
    }
}
