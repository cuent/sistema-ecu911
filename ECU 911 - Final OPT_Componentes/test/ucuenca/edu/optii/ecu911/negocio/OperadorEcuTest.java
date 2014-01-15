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
public class OperadorEcuTest {
    
    public OperadorEcuTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMirol method, of class OperadorEcu.
     */
    @Test
    public void testGetMirol() {
        System.out.println("getMirol");
        OperadorEcu instance = new OperadorEcu();
        Rol expResult = null;
        Rol result = instance.getMirol();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMirol method, of class OperadorEcu.
     */
    @Test
    public void testSetMirol() {
        System.out.println("setMirol");
        Rol mirol = null;
        OperadorEcu instance = new OperadorEcu();
        instance.setMirol(mirol);
       
    }

    /**
     * Test of getMicentro method, of class OperadorEcu.
     */
    @Test
    public void testGetMicentro() {
        System.out.println("getMicentro");
        OperadorEcu instance = new OperadorEcu();
        CentroEcu_Observado expResult = null;
        CentroEcu_Observado result = instance.getMicentro();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMicentro method, of class OperadorEcu.
     */
    @Test
    public void testSetMicentro() {
        System.out.println("setMicentro");
        CentroEcu_Observado micentro = null;
        OperadorEcu instance = new OperadorEcu();
        instance.setMicentro(micentro);
        
    }

    /**
     * Test of getUsuario method, of class OperadorEcu.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        OperadorEcu instance = new OperadorEcu();
        String expResult = "";
        String result = instance.getUsuario();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setUsuario method, of class OperadorEcu.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "";
        OperadorEcu instance = new OperadorEcu();
        instance.setUsuario(usuario);
        
    }

    /**
     * Test of getPassw method, of class OperadorEcu.
     */
    @Test
    public void testGetPassw() {
        System.out.println("getPassw");
        OperadorEcu instance = new OperadorEcu();
        String expResult = "";
        String result = instance.getPassw();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of setPassw method, of class OperadorEcu.
     */
    @Test
    public void testSetPassw() {
        System.out.println("setPassw");
        String passw = "";
        OperadorEcu instance = new OperadorEcu();
        instance.setPassw(passw);
        
    }

    /**
     * Test of getSueldo method, of class OperadorEcu.
     */
    @Test
    public void testGetSueldo() {
        System.out.println("getSueldo");
        OperadorEcu instance = new OperadorEcu();
        double expResult = 0.0;
        double result = instance.getSueldo();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setSueldo method, of class OperadorEcu.
     */
    @Test
    public void testSetSueldo() {
        System.out.println("setSueldo");
        double sueldo = 0.0;
        OperadorEcu instance = new OperadorEcu();
        instance.setSueldo(sueldo);
        
    }

    /**
     * Test of loguearse method, of class OperadorEcu.
     */
    @Test
    public void testLoguearse() {
        System.out.println("loguearse");
        OperadorEcu instance = new OperadorEcu();
        instance.loguearse();
       
    }

    /**
     * Test of atenderLlamada method, of class OperadorEcu.
     */
    @Test
    public void testAtenderLlamada() {
        System.out.println("atenderLlamada");
        OperadorEcu instance = new OperadorEcu();
        instance.atenderLlamada();

    }

    /**
     * Test of rastrearLlamada method, of class OperadorEcu.
     */
    @Test
    public void testRastrearLlamada() {
        System.out.println("rastrearLlamada");
        OperadorEcu instance = new OperadorEcu();
        instance.rastrearLlamada();
        
    }

    /**
     * Test of recibirDatosIncidente method, of class OperadorEcu.
     */
    @Test
    public void testRecibirDatosIncidente() {
        System.out.println("recibirDatosIncidente");
        OperadorEcu instance = new OperadorEcu();
        instance.recibirDatosIncidente();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of validarIncidente method, of class OperadorEcu.
     */
    @Test
    public void testValidarIncidente() {
        System.out.println("validarIncidente");
        OperadorEcu instance = new OperadorEcu();
        instance.validarIncidente();
       
    }

    /**
     * Test of lanzarAlarma method, of class OperadorEcu.
     */
    @Test
    public void testLanzarAlarma() {
        System.out.println("lanzarAlarma");
        OperadorEcu instance = new OperadorEcu();
        instance.lanzarAlarma();
        
    }

    /**
     * Test of grabar method, of class OperadorEcu.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        OperadorEcu instance = new OperadorEcu();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buscarPorCedula method, of class OperadorEcu.
     */
    @Test
    public void testBuscarPorCedula() {
        System.out.println("buscarPorCedula");
        OperadorEcu instance = new OperadorEcu();
        boolean expResult = false;
        boolean result = instance.buscarPorCedula();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buscar method, of class OperadorEcu.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        OperadorEcu instance = new OperadorEcu();
        boolean expResult = false;
        boolean result = instance.buscar();
        assertEquals(expResult, result);
      
    }
}
