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
public class ClienteTest {
     String expResult = "Los olivos";
    public ClienteTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = new Cliente();
        instance.direccion="Los olivos";
       
        String result = instance.getDireccion();
        assertEquals(expResult, result);
       }

    /**
     * Test of setDireccion method, of class Cliente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "calle de la quena";
        Cliente instance = new Cliente();
        instance.setDireccion(direccion);
               
    }

    /**
     * Test of getMifono method, of class Cliente.
     */
    @Test
    public void testGetMifono() {
        System.out.println("getMifono");
        Cliente instance = new Cliente();
        Telefono expResult = null;
        Telefono result = instance.getMifono();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMifono method, of class Cliente.
     */
    @Test
    public void testSetMifono() {
        System.out.println("setMifono");
        Telefono mifono = new Telefono();
        mifono.setId(5);
        Cliente instance = new Cliente();
        instance.setMifono(mifono);
        
    }

    /**
     * Test of llamar method, of class Cliente.
     */
    @Test
    public void testLlamar() {
        System.out.println("llamar");
        Cliente instance = new Cliente();
        instance.llamar();
        
    }

    /**
     * Test of grabar method, of class Cliente.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Cliente instance = new Cliente();
        instance.setCedula("010203");
        instance.setNombres("cliente nuevo");
        instance.setDireccion("");
          Telefono fono = new Telefono();
          fono.setId(0);
        instance.setMifono(fono);
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buscar method, of class Cliente.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Cliente instance = new Cliente();
        Telefono fono=new Telefono();
        fono.setId(0);
        instance.setMifono(fono);
        boolean expResult = false;
        boolean result = instance.buscar();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buscarCedula method, of class Cliente.
     */
    @Test
    public void testBuscarCedula() {
        System.out.println("buscarCedula");
        Cliente instance = new Cliente();
        instance.setCedula("010203");
        boolean expResult = true;
        boolean result = instance.buscarCedula();
        assertEquals(expResult, result);
       
    }
}
