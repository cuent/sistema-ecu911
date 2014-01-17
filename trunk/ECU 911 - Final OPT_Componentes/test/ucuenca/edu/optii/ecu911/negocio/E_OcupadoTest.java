package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class E_OcupadoTest {
    /**
     * Test of SuspenderTelefono method, of class E_Ocupado.
     */
    @Test
    public void testSuspenderTelefono() {
        System.out.println("SuspenderTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        String expResult = "Telefono Suspendido";
        String result = instance.SuspenderTelefono(tel);
        assertEquals(expResult, result);
    }

    /**
     * Test of OcuparTelefono method, of class E_Ocupado.
     */
    @Test
    public void testOcuparTelefono() {
        System.out.println("OcuparTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        String expResult = "Telefono Ocupado";
        String result = instance.OcuparTelefono(tel);
        assertEquals(expResult, result);
    }

    /**
     * Test of EsperarTelefono method, of class E_Ocupado.
     */
    @Test
    public void testEsperarTelefono() {
        System.out.println("EsperarTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        String expResult = "Telefono en Espera";
        String result = instance.EsperarTelefono(tel);
        assertEquals(expResult, result);
    }

    /**
     * Test of LiberarTelefono method, of class E_Ocupado.
     */
    @Test
    public void testLiberarTelefono() {
        System.out.println("LiberarTelefono");
        Telefono tel = null;
        E_Ocupado instance = new E_Ocupado();
        String expResult = "Telefono Disponible";
        String result = instance.LiberarTelefono(tel);
        assertEquals(expResult, result);
    }
}
