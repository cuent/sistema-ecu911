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
public class TipoIncidenteTest {
    /**
     * Test of getMisentidades method, of class TipoIncidente.
     */
    @Test
    public void testGetMisentidades() {
        System.out.println("getMisentidades");
        TipoIncidente instance = new TipoIncidente();
        List expResult = new ArrayList();
        instance.setMisentidades(expResult);
        assertEquals(expResult, instance.getMisentidades());
    }

    /**
     * Test of setMisentidades method, of class TipoIncidente.
     */
    @Test
    public void testSetMisentidades() {
        System.out.println("setMisentidades");
        List<EntidadCooperativa> misentidades = null;
        TipoIncidente instance = new TipoIncidente();
        instance.setMisentidades(misentidades);
        assertEquals(misentidades, instance.getMisentidades());   
    }

    /**
     * Test of getId method, of class TipoIncidente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TipoIncidente instance = new TipoIncidente();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);   
    }

    /**
     * Test of setId method, of class TipoIncidente.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 3;
        TipoIncidente instance = new TipoIncidente();
        instance.setId(id);
       assertEquals(id, instance.getId());
    }

    /**
     * Test of getDescripcion method, of class TipoIncidente.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        TipoIncidente instance = new TipoIncidente();
        instance.descripcion = "telefono 1";
        String result = instance.getDescripcion();
        assertEquals("telefono 1", result);
    }

    /**
     * Test of setDescripcion method, of class TipoIncidente.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        TipoIncidente instance = new TipoIncidente();
        instance.setDescripcion(descripcion);
        assertEquals(descripcion, instance.getDescripcion());
    }

    /**
     * Test of grabar method, of class TipoIncidente.
     */
  /* @Test
    public void testGrabar() {
        System.out.println("grabar");
        TipoIncidente instance = new TipoIncidente();
        boolean expResult = true;
        boolean result = instance.grabar();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of listar method, of class TipoIncidente.
     */
    /*@Test
    public void testListar() {
        System.out.println("listar");
        String ciudad = "Cuenca";
        String descripcion = "incendio forestal";
        TipoIncidente instance = new TipoIncidente();
        instance.descripcion=descripcion;
        ArrayList expResult = new ArrayList();
        expResult.add("Policia");
        ArrayList result = instance.listar(ciudad, descripcion);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of buscarDescripcion method, of class TipoIncidente.
     */
 /*   @Test
    public void testBuscarDescripcion() {
        System.out.println("buscarDescripcion");
        TipoIncidente instance = new TipoIncidente();
        instance.id=2;
        boolean result = instance.buscarDescripcion();
        assertTrue("esperando buscado true", result);      
    }*/
}