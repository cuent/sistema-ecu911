package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Operador_EntidadCTest {
    /**
     * Test of getCorreo_el method, of class Operador_EntidadC.
     */
    @Test
    public void testGetCorreo_el() {
        System.out.println("getCorreo_el");
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.correo_el = "may_bip@hotmail.com";
        String result = instance.getCorreo_el();
        assertEquals("may_bip@hotmail.com", result);   
    }
    /**
     * Test of setCorreo_el method, of class Operador_EntidadC.
     */
    @Test
    public void testSetCorreo_el() {
        System.out.println("setCorreo_el");
        String correo_el = "correo@ucuenca.edu.ec";
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.setCorreo_el(correo_el);
        assertEquals(correo_el, instance.getCorreo_el());
    }
    /**
     * Test of getSueldo method, of class Operador_EntidadC.
     */
    @Test
    public void testGetSueldo() {
        System.out.println("getSueldo");
        Operador_EntidadC instance = new Operador_EntidadC();
        double expResult = 1500.0;
        double result = instance.getSueldo();
        assertEquals(expResult, result, 1500.0);
    }
    /**
     * Test of setSueldo method, of class Operador_EntidadC.
     */
    @Test
    public void testSetSueldo() {
        System.out.println("setSueldo");
        double sueldo = 850.0;
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.setSueldo(sueldo);
        assertEquals(sueldo, instance.getSueldo(),850.0);
    }
    /**
     * Test of getMientidad method, of class Operador_EntidadC.
     */
    @Test
    public void testGetMientidad() {
        System.out.println("getMientidad");
        Operador_EntidadC instance = new Operador_EntidadC();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.getMientidad();
        assertEquals(expResult, result);
    }
    /**
     * Test of setMientidad method, of class Operador_EntidadC.
     */
    @Test
    public void testSetMientidad() {
        System.out.println("setMientidad");
        EntidadBomberos mientidad = new EntidadBomberos();
        mientidad.ciudad="Cuenca";
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.setMientidad(mientidad);
        assertEquals(instance.mientidad.ciudad, "Cuenca");
    }

    /**
     * Test of grabar method, of class Operador_EntidadC.
     */
  /*  @Test
    public void testGrabar() {
        System.out.println("grabar");
        Operador_EntidadC instance = new Operador_EntidadC();
        instance.cedula="010204";
        instance.correo_el="jorge@gmail";
        instance.sueldo=0;
        instance.nombres="jorge";
        EntidadBomberos b=new EntidadBomberos();
        instance.setMientidad(b);
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);  
    }*/
}