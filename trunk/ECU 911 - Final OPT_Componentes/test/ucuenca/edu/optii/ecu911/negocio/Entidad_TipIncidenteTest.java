package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Entidad_TipIncidenteTest {
    /**
     * Test of getMientidad method, of class Entidad_TipIncidente.
     */
    @Test
    public void testGetMientidad() {
        System.out.println("getMientidad");
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.getMientidad();
        assertEquals(expResult, result); 
    }
    /**
     * Test of setMientidad method, of class Entidad_TipIncidente.
     */
    @Test
    public void testSetMientidad() {
        System.out.println("setMientidad");
        EntidadBomberos mientidad=new EntidadBomberos();
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        instance.setMientidad(mientidad);
        assertEquals( mientidad.getNombre(), "Bomberos");
    }

    /**
     * Test of getMiTipoIn method, of class Entidad_TipIncidente.
     */
    @Test
    public void testGetMiTipoIn() {
        System.out.println("getMiTipoIn");
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        TipoIncidente expResult = new TipoIncidente();
        expResult.descripcion="secuestro express";
        instance.setMiTipoIn(expResult);
        assertEquals(expResult, instance.getMiTipoIn());  
    }

    /**
     * Test of setMiTipoIn method, of class Entidad_TipIncidente.
     */
    @Test
    public void testSetMiTipoIn() {
        System.out.println("setMiTipoIn");
        TipoIncidente miTipoIn = new TipoIncidente();
        miTipoIn.descripcion="accidente de transito";
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        instance.setMiTipoIn(miTipoIn);
        assertEquals(instance.getMiTipoIn().descripcion, "accidente de transito");
    }
    /**
     * Test of grabar method, of class Entidad_TipIncidente.
     */
   /* @Test
    public void testGrabar() {
        System.out.println("grabar");
        int inc = 2;
        int ent = 2;
        Entidad_TipIncidente instance = new Entidad_TipIncidente();
        boolean expResult = false;
        boolean result = instance.grabar(inc, ent);
        assertEquals(expResult, result);
    }*/
}