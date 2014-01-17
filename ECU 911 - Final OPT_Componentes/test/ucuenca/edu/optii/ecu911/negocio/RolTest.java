package ucuenca.edu.optii.ecu911.negocio;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class RolTest {
    /**
     * Test of getMispermisos method, of class Rol.
     */
    @Test
    public void testGetMispermisos() {
        System.out.println("getMispermisos");
        Rol instance = new Rol();
        List expResult = new ArrayList();
        List result = instance.getMispermisos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMispermisos method, of class Rol.
     */
    @Test
    public void testSetMispermisos() {
        System.out.println("setMispermisos");
        List<Permiso> mispermisos = null;
        Rol instance = new Rol();
        instance.setMispermisos(mispermisos);
        assertEquals(instance.getMispermisos(), mispermisos);
    }

    /**
     * Test of getId method, of class Rol.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Rol instance = new Rol();
        int expResult = 2;
        instance.setId(expResult);
        assertEquals(expResult, instance.getId());     
    }

    /**
     * Test of setId method, of class Rol.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 8;
        Rol instance = new Rol();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getDescripcion method, of class Rol.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Rol instance = new Rol();
        instance.descripcion = "admin1";
        String result = instance.getDescripcion();
        assertEquals("admin1", result);
    }

    /**
     * Test of setDescripcion method, of class Rol.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "rol cajero";
        Rol instance = new Rol();
        instance.setDescripcion(descripcion);
        assertEquals(instance.getDescripcion(), descripcion);
    }

    /**
     * Test of grabar method, of class Rol.
     */
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Rol instance = new Rol();
        boolean expResult = false;
        boolean result = instance.grabar();
        assertEquals(expResult, result); 
    }

    /**
     * Test of buscarIde method, of class Rol.
     */
    @Test
    public void testBuscarIde() {
        System.out.println("buscarIde");
        Rol instance = new Rol();
        boolean expResult = true;
        boolean result = instance.buscarIde();
        assertEquals(expResult, result);      
    }
}