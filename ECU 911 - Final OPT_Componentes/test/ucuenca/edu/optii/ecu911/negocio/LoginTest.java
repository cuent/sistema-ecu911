package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class LoginTest {
    /**
     * Test of getId method, of class Login.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Login instance = new Login();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);     
    }

    /**
     * Test of setId method, of class Login.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 157;
        Login instance = new Login();
        instance.setId(id);
        assertEquals(id, instance.getId());     
    }

    /**
     * Test of getFecha_inicio method, of class Login.
     */
    @Test
    public void testGetFecha_inicio() {
        System.out.println("getFecha_inicio");
        Login instance = new Login();
        instance.setFecha_inicio("20/02/2013");
        String result = instance.getFecha_inicio();
        assertEquals("20/02/2013", result);
    }
    /**
     * Test of setFecha_inicio method, of class Login.
     */
    @Test
    public void testSetFecha_inicio() {
        System.out.println("setFecha_inicio");
        String fecha_inicio = "16/01/2014";
        Login instance = new Login();
        instance.setFecha_inicio(fecha_inicio);
        assertEquals(instance.getFecha_inicio(), fecha_inicio);   
    }

    /**
     * Test of getFecha_fin method, of class Login.
     */
    @Test
    public void testGetFecha_fin() {
        System.out.println("getFecha_fin");
        Login instance = new Login();
       instance.setFecha_fin("10/02/2013");
        String result = instance.getFecha_fin();
        assertEquals("10/02/2013", result);     
    }
    /**
     * Test of setFecha_fin method, of class Login.
     */
    @Test
    public void testSetFecha_fin() {
        System.out.println("setFecha_fin");
        String fecha_fin = "20/01/2014";
        Login instance = new Login();
        instance.setFecha_fin(fecha_fin);
        assertEquals(instance.getFecha_fin(), fecha_fin);  
    }
    /**
     * Test of getUsu method, of class Login.
     */
    @Test
    public void testGetUsu() {
        System.out.println("getUsu");
        Login instance = new Login();
        OperadorEcu expResult = null;
        OperadorEcu result = instance.getUsu();
        assertSame(expResult, result);     
    }

    /**
     * Test of setUsu method, of class Login.
     */
    @Test(timeout=100)
    public void testSetUsu() {
        System.out.println("setUsu");
        OperadorEcu usu = null ;
        Login instance = new Login();
        instance.setUsu(usu);
    }
 
}