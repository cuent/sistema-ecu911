/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public VisitableTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of aceptar method, of class Visitable.
     */
    @Test
    public void testAceptar() {
        System.out.println("aceptar");
        Visitor visitor = null;
        Visitable instance = new VisitableImpl();
        String expResult = "";
        String result = instance.aceptar(visitor);
        assertEquals(expResult, result);
       
    }

    public class VisitableImpl implements Visitable {

        public String aceptar(Visitor visitor) {
            return "";
        }
    }
}
