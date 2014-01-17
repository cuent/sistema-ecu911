package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class EntidadFactoryTest { 
    /**
     * Test of crearEntidad method, of class EntidadFactory.
     */
    @Test
    public void testCrearEntidad() {
        System.out.println("crearEntidad");
        String tipo = "entidad cooperativa nueva";
        EntidadFactory instance = new EntidadFactory();
        EntidadCooperativa expResult = null;
        EntidadCooperativa result = instance.crearEntidad(tipo);
        assertEquals(expResult, result);     
    }
}