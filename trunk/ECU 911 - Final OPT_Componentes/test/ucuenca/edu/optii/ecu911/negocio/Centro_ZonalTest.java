package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Centro_ZonalTest {
    String expResult = "Gualaceo";
 
    /**
     * Test of getNombre method, of class Centro_Zonal.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Centro_Zonal instance = new Centro_Zonal();
        instance.nombre="Gualaceo";
        String result = instance.nombre;
        assertEquals(expResult, result);
   
    }

}
