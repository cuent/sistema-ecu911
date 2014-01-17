package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class VisitableTest {
    /**
     * Test of aceptar method, of class Visitable.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = null;
        Visitable instance = new VisitableImpl();
        String expResult = "visita aceptada";
        String result = instance.aceptar(visitor);
        assertEquals(expResult, result);     
    }

    public class VisitableImpl implements Visitable {

        public String aceptar(Visitor visitor) {
            return "visita aceptada";
        }
    }
}
