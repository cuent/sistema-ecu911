package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Ubicacion_IncidenteTest {
    /**
     * Test of getMitipo method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetMitipo() {
        System.out.println("getMitipo");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        TipoIncidente expResult = null;
        TipoIncidente result = instance.getMitipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMitipo method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetMitipo() {
        System.out.println("setMitipo");
        TipoIncidente mitipo = new TipoIncidente();
        mitipo.descripcion="asaltos";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setMitipo(mitipo);
        assertEquals(instance.getMitipo().descripcion, "asaltos");
    }

    /**
     * Test of getCalle_principal method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetCalle_principal() {
        System.out.println("getCalle_principal");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.calle_principal = "calle san roque";
        String result = instance.getCalle_principal();
        assertEquals("calle san roque", result);       
    }

    /**
     * Test of setCalle_principal method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetCalle_principal() {
        System.out.println("setCalle_principal");
        String calle_principal = "calle remigio crespo";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setCalle_principal(calle_principal);
        assertEquals(instance.getCalle_principal(), calle_principal);
    }

    /**
     * Test of getInterseccion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetInterseccion() {
        System.out.println("getInterseccion");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.interseccion  = "y calle vieja";
        String result = instance.getInterseccion();
        assertEquals("y calle vieja", result);
    }

    /**
     * Test of setInterseccion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetInterseccion() {
        System.out.println("setInterseccion");
        String interseccion = "interseccion miraflores";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setInterseccion(interseccion);
        assertEquals(instance.getInterseccion(), interseccion);
    }

    /**
     * Test of getReferencia_ubicacion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetReferencia_ubicacion() {
        System.out.println("getReferencia_ubicacion");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.referencia_ubicacion  = "cerca del parque miraflores";
        String result = instance.getReferencia_ubicacion();
        assertEquals("cerca del parque miraflores", result);   
    }

    /**
     * Test of setReferencia_ubicacion method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetReferencia_ubicacion() {
        System.out.println("setReferencia_ubicacion");
        String referencia_ubicacion = "cerca del mall del rio";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setReferencia_ubicacion(referencia_ubicacion);
        assertEquals(instance.getReferencia_ubicacion(), referencia_ubicacion);
    }

    /**
     * Test of getCiudad method, of class Ubicacion_Incidente.
     */
    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.ciudad = "Ambato";
        String result = instance.getCiudad();
        assertEquals("Ambato", result);
    }

    /**
     * Test of setCiudad method, of class Ubicacion_Incidente.
     */
    @Test
    public void testSetCiudad() {
        System.out.println("setCiudad");
        String ciudad = "Manabi";
        Ubicacion_Incidente instance = new Ubicacion_Incidente();
        instance.setCiudad(ciudad);
        assertEquals(ciudad, instance.getCiudad());
    }
}