package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Servicio_CentroEcuTest {
    /**
     * Test of getMiservicio method, of class Servicio_CentroEcu.
     */
    @Test
    public void testGetMiservicio() {
        System.out.println("getMiservicio");
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        Servicio expResult = null;
        Servicio result = instance.getMiservicio();
        assertEquals(expResult, result);
    }
    /**
     * Test of setMiservicio method, of class Servicio_CentroEcu.
     */
    @Test
    public void testSetMiservicio() {
        System.out.println("setMiservicio");
        Servicio miservicio = new Servicio();
        miservicio.descripcion="gestion de vigilancia";
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        instance.setMiservicio(miservicio);
        assertEquals(instance.getMiservicio().descripcion, "gestion de vigilancia");
    }

    /**
     * Test of getMicentro method, of class Servicio_CentroEcu.
     */
    @Test
    public void testGetMicentro() {
        System.out.println("getMicentro");
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        CentroEcu_Observado expResult = new CentroEcu_Observado();
        instance.setMicentro(expResult);
        assertEquals(expResult,  instance.getMicentro());
    }
    /**
     * Test of setMicentro method, of class Servicio_CentroEcu.
     */
    @Test
    public void testSetMicentro() {
        System.out.println("setMicentro");
        CentroEcu_Observado micentro = new CentroEcu_Observado();
        micentro.setCiudad("Loja");
        Servicio_CentroEcu instance = new Servicio_CentroEcu();
        instance.setMicentro(micentro);
        assertEquals(instance.getMicentro().ciudad, "Loja");
    }
}