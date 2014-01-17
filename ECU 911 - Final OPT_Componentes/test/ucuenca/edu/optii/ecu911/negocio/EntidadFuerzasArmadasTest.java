package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class EntidadFuerzasArmadasTest {
 
    /**
     * Test of recibir_alarma method, of class EntidadFuerzasArmadas.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        EntidadFuerzasArmadas instance = new EntidadFuerzasArmadas();
        String expResult = "Fuerzas Armadas en camino";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);   
    }

    /**
     * Test of aceptar method, of class EntidadFuerzasArmadas.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = new LlamarEntidad();
        EntidadFuerzasArmadas instance = new EntidadFuerzasArmadas();
        String expResult = "Fuerzas Armadas";
        String result = instance.aceptar(visitor);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class EntidadFuerzasArmadas.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        EntidadFuerzasArmadas instance = new EntidadFuerzasArmadas();
        String expResult = "Fuerzas Armadas";
        String result = instance.getNombre();
        assertEquals(expResult, result);   
    }
}