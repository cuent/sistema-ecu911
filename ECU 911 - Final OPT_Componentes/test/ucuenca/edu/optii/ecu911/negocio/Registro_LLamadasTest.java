package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Registro_LLamadasTest {
    /**
     * Test of getCedula method, of class Registro_LLamadas.
     */
    @Test
    public void testGetCedula() {
        System.out.println("getCedula");
        Registro_LLamadas instance = new Registro_LLamadas();
        instance.cedula = "0102244887";
        String result = instance.getCedula();
        assertEquals("0102244887", result);
    }

    /**
     * Test of setCedula method, of class Registro_LLamadas.
     */
    @Test
    public void testSetCedula() {
        System.out.println("setCedula");
        String cedula = "0104645676";
        Registro_LLamadas instance = new Registro_LLamadas();
        instance.setCedula(cedula);
        assertEquals(cedula, instance.getCedula());
    }

    /**
     * Test of getTelefono method, of class Registro_LLamadas.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Registro_LLamadas instance = new Registro_LLamadas();
        instance.telefono="072998855";
        String result = instance.getTelefono();
        assertEquals("072998855", result);
    }

    /**
     * Test of setTelefono method, of class Registro_LLamadas.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "072558452";
        Registro_LLamadas instance = new Registro_LLamadas();
        instance.setTelefono(telefono);
         assertEquals(telefono, instance.getTelefono());
    }

    /**
     * Test of getFecha method, of class Registro_LLamadas.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Registro_LLamadas instance = new Registro_LLamadas();
       instance.fecha="10/10/2010";
        String result = instance.getFecha();
        assertEquals("10/10/2010", result);   
    }

    /**
     * Test of setFecha method, of class Registro_LLamadas.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "10/10/2013";
        Registro_LLamadas instance = new Registro_LLamadas();
        instance.setFecha(fecha);
        assertEquals(instance.getFecha(), fecha);  
    }

    /**
     * Test of grabar method, of class Registro_LLamadas.
     */
   /* @Test
    public void testGrabar() {
        System.out.println("grabar");
        Registro_LLamadas instance = new Registro_LLamadas();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result);    
    }*/
}