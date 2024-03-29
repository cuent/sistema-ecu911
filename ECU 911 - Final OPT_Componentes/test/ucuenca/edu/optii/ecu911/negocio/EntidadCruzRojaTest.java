package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class EntidadCruzRojaTest {
  
    /**
     * Test of recibir_alarma method, of class EntidadCruzRoja.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        EntidadCruzRoja instance = new EntidadCruzRoja();
        String expResult = "Cruz Roja en camino...";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);
    }

    /**
     * Test of aceptar method, of class EntidadCruzRoja.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = new LlamarEntidad();
        EntidadCruzRoja instance = new EntidadCruzRoja();
        instance.tipo="Policia";
        String expResult = "Cruz Roja";
        String result = instance.aceptar(visitor);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class EntidadCruzRoja.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        EntidadCruzRoja instance = new EntidadCruzRoja();
        String expResult = "Cruz Roja";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }
}