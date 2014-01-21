package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class ClienteTest {
     String resDireccion = "Los olivos";
  
    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = new Cliente();
        instance.direccion="Los olivos";      
        String result = instance.getDireccion();
        assertEquals(resDireccion, result);
       }

    /**
     * Test of setDireccion method, of class Cliente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "calle de la quena";
        Cliente instance = new Cliente();
        instance.setDireccion(direccion);
        assertEquals(direccion, instance.getDireccion());       
    }

    /**
     * Test of getMifono method, of class Cliente.
     */
    @Test
    public void testGetMifono() {
        System.out.println("getMifono");
        Cliente instance = new Cliente();
        Telefono expResult = null;
        Telefono result = instance.getMifono();
        assertEquals(expResult, result);   
    }

    /**
     * Test of setMifono method, of class Cliente.
     */
    @Test
    public void testSetMifono() {
        System.out.println("setMifono");
        Telefono mifono = new Telefono();
        mifono.setId(5);
        Cliente instance = new Cliente();
        instance.setMifono(mifono);
        assertEquals(mifono, instance.getMifono());
    }
}