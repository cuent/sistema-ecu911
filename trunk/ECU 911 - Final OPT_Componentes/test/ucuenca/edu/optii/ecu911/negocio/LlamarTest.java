package ucuenca.edu.optii.ecu911.negocio;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author cuent
 */
public class LlamarTest {
    private Llamar llamar = null;
    private ArrayList expResult = new ArrayList();

    @Before
    public void setUp() {
        ArrayList l = new ArrayList();
        l.add("Bomberos");
        expResult.add("Centro ECU 911 Nacional");
        expResult.add("Bomberos");
        llamar = new Llamar(l, "nacional");
    }

    @After
    public void tearDown() {
        llamar = null;
    }
    /**
     * Test of alertar method, of class Llamar.
     */
    @Test
    public void testAlertar() {
        System.out.println("alertar");
        ArrayList result = llamar.alertar();
        assertEquals("Las pruebas para una entidad bomberos en un Ecu Nacional",expResult, result);
    }
}