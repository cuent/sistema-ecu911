package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class Centro_LocalTest {
    String expResult = "Cuenca";
    
    /**
     * Test of getNombre method, of class Centro_Local.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Centro_Local instance = new Centro_Local();
        instance.nombre="Cuenca";
        String result = instance.nombre;
        assertEquals(expResult, result);      
    }

    /**
     * Test of notificar method, of class Centro_Local.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        Centro_Local instance = new Centro_Local();
        String result = instance.notificar();
        assertEquals(instance.getNombre(), "Centro ECU 911 Local");
    }
}
