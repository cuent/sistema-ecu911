package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class PermisoTest {
    /**
     * Test of getId method, of class Permiso.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Permiso instance = new Permiso();
        int expResult = 2;
        instance.setId(expResult);
        assertEquals(expResult, instance.getId());
    }
    /**
     * Test of setId method, of class Permiso.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 2;
        Permiso instance = new Permiso();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getDescripcion method, of class Permiso.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Permiso instance = new Permiso();
        instance.descripcion="listados";
        String result = instance.getDescripcion();
        assertEquals("listados", result);   
    }

    /**
     * Test of setDescripcion method, of class Permiso.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "acceder a db";
        Permiso instance = new Permiso();
        instance.setDescripcion(descripcion);
        assertEquals(instance.descripcion, descripcion);     
    }

}
