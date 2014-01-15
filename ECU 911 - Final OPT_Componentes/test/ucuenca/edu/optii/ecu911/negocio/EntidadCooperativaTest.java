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
public class EntidadCooperativaTest {
    
    public EntidadCooperativaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTipo method, of class EntidadCooperativa.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.tipo="Policia";
        String result = instance.getTipo();
        assertEquals("Policia", result);
       
    }

    /**
     * Test of setTipo method, of class EntidadCooperativa.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.setTipo(tipo);
       
    }

    /**
     * Test of getMifono method, of class EntidadCooperativa.
     */
    @Test
    public void testGetMifono() {
        System.out.println("getMifono");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        Telefono expResult = null;
        Telefono result = instance.getMifono();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMifono method, of class EntidadCooperativa.
     */
    @Test
    public void testSetMifono() {
        System.out.println("setMifono");
        Telefono mifono = new Telefono();
        mifono.setId(1);
        mifono.setNumero("072558844");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.setMifono(mifono);
      
    }

    /**
     * Test of getId method, of class EntidadCooperativa.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setId method, of class EntidadCooperativa.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.setId(id);
       
    }

    /**
     * Test of getCiudad method, of class EntidadCooperativa.
     */
    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.ciudad="Loja";
        String expResult = "Loja";
        String result = instance.getCiudad();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCiudad method, of class EntidadCooperativa.
     */
    @Test
    public void testSetCiudad() {
        System.out.println("setCiudad");
        String ciudad = "";
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.setCiudad(ciudad);
       
    }

    /**
     * Test of recibir_info method, of class EntidadCooperativa.
     */
    @Test
    public void testRecibir_info() {
        System.out.println("recibir_info");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.recibir_info();
       
    }

    /**
     * Test of recibir_alarma method, of class EntidadCooperativa.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        String expResult = "";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of generar_reportes_incidente method, of class EntidadCooperativa.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testGenerar_reportes_incidente() {
        System.out.println("generar_reportes_incidente");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.generar_reportes_incidente();
    
    }

    /**
     * Test of actualizar method, of class EntidadCooperativa.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testActualizar() {
        System.out.println("actualizar");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.actualizar();
        
    }

    /**
     * Test of grabar method, of class EntidadCooperativa.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Telefono mitelefono=new Telefono();
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        instance.ciudad="Cuenca";
        instance.mifono=mitelefono;
        boolean expResult = false;
        boolean result = instance.grabar("Cruz Roja");
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buscarEntidadHijo method, of class EntidadCooperativa.
     */
    @Test
    public void testBuscarEntidadHijo() {
        System.out.println("buscarEntidadHijo");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
       instance.id=1;
        String result = instance.buscarEntidadHijo();
        assertEquals("Policia", result);
      
    }

    /**
     * Test of buscar method, of class EntidadCooperativa.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.buscar();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of aceptar method, of class EntidadCooperativa.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = null;
        EntidadCooperativa instance = new EntidadCooperativaImpl();
        String expResult = "";
        String result = instance.aceptar(visitor);
        assertEquals(expResult, result);
       
    }

    public class EntidadCooperativaImpl extends EntidadCooperativa {

        public String aceptar(Visitor visitor) {
            return "";
        }
    }
}
