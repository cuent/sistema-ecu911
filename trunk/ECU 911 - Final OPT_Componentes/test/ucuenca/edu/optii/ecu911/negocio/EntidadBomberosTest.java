package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class EntidadBomberosTest {
    /**
     * Test of recibir_alarma method, of class EntidadBomberos.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        EntidadBomberos instance = new EntidadBomberos();
        String expResult = "Bomberos en camino...";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);    
    }

    /**
     * Test of aceptar method, of class EntidadBomberos.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = new LlamarEntidad() ;
        EntidadBomberos instance = new EntidadBomberos();
        String result=instance.aceptar(visitor);
        assertEquals("Bomberos", result);
    }

    /**
     * Test of getNombre method, of class EntidadBomberos.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        EntidadBomberos instance = new EntidadBomberos();
        String expResult = "Bomberos";
        String result = instance.getNombre();
        assertEquals(expResult, result);    
    }
}
