package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class EntidadPoliciaTest {

    /**
     * Test of recibir_alarma method, of class EntidadPolicia.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        EntidadPolicia instance = new EntidadPolicia();
        String expResult = "Policia en Camino...";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);    
    }
    /**
     * Test of aceptar method, of class EntidadPolicia.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = new LlamarEntidad();
        EntidadPolicia instance = new EntidadPolicia();
        String expResult = "Policia";
        String result = instance.aceptar(visitor);
        assertEquals(expResult, result);   
    }
    /**
     * Test of getNombre method, of class EntidadPolicia.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        EntidadPolicia instance = new EntidadPolicia();
        String expResult = "Policia";
        String result = instance.getNombre();
        assertEquals(expResult, result);  
    }
}
