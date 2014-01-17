package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ucuenca.edu.optii.ecu911.negocio.excepciones.TelefonoVerificacionException;
/**
 *
 * @author May
 */
public class TelefonoTest {
    /**
     * Test of EstablecerEstado method, of class Telefono.
     */
    @Test
    public void testEstablecerEstado() {
        System.out.println("EstablecerEstado");
        Intz_EstadosTelefono es = new E_Ocupado();
        Telefono instance = new Telefono();
        instance.EstablecerEstado(es);
        assertEquals(es.OcuparTelefono(instance), instance.miestado.OcuparTelefono(instance));
    }

    /**
     * Test of SuspenderTelefono method, of class Telefono.
     */
    @Test(timeout=200)
    public void testSuspenderTelefono() {
        System.out.println("SuspenderTelefono");
        Telefono instance = new Telefono();
        instance.SuspenderTelefono();
    }

    /**
     * Test of OcuparTelefono method, of class Telefono.
     */
    @Test(timeout=300)
    public void testOcuparTelefono() {
        System.out.println("OcuparTelefono");
        Telefono instance = new Telefono();
        instance.OcuparTelefono();
    }

    /**
     * Test of EsperarTelefono method, of class Telefono.
     */
    @Test(timeout=200)
    public void testEsperarTelefono() {
        System.out.println("EsperarTelefono");
        Telefono instance = new Telefono();
        instance.EsperarTelefono();
    }

    /**
     * Test of LiberarTelefono method, of class Telefono.
     */
    @Test(timeout=200)
    public void testLiberarTelefono() {
        System.out.println("LiberarTelefono");
        Telefono instance = new Telefono();
        instance.LiberarTelefono();  
    }

    /**
     * Test of getId method, of class Telefono.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Telefono instance = new Telefono();
        int expResult = 1;
        instance.setId(expResult);
        assertEquals(expResult, instance.getId()); 
    }
    /**
     * Test of setId method, of class Telefono.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 2;
        Telefono instance = new Telefono();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getTipo method, of class Telefono.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Telefono instance = new Telefono();
        String expResult = "celular";
        instance.setTipo(expResult);
        assertEquals(expResult, instance.getTipo());
    }

    /**
     * Test of setTipo method, of class Telefono.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "convencional";
        Telefono instance = new Telefono();
        instance.setTipo(tipo);
        assertEquals(tipo, instance.getTipo());
    }

    /**
     * Test of getNumero method, of class Telefono.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Telefono instance = new Telefono();
        instance.setNumero("0992960070");
        String result = instance.getNumero();
        assertEquals("0992960070", result);    
    }

    /**
     * Test of setNumero method, of class Telefono.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "0992628036";
        Telefono instance = new Telefono();
        instance.setNumero(numero);
        assertEquals(numero, instance.getNumero());
    }

    /**
     * Test of grabar method, of class Telefono.
     */
    @Test(expected=TelefonoVerificacionException.class)
    public void testGrabar() throws Exception {
        System.out.println("grabar");
        Telefono instance = new Telefono();
        instance.grabar();
    }
    /**
     * Test of buscarNumeroSegunIde method, of class Telefono.
     */
    @Test
    public void testBuscarNumeroSegunIde() {
        System.out.println("buscarNumeroSegunIde");
        Telefono instance = new Telefono();
        instance.id=2;
        boolean result = instance.buscarNumeroSegunIde();
        assertTrue("Esperando true", result);  
    }
    /**
     * Test of buscarNumero method, of class Telefono.
     */
    @Test
    public void testBuscarNumero() {
        System.out.println("buscarNumero");
        Telefono instance = new Telefono();
        boolean result = instance.buscarNumero();
        assertTrue("esperando true", result);     
    }
}
