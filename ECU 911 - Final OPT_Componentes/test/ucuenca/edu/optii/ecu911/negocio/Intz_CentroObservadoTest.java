package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Intz_CentroObservadoTest {
    /**
     * Test of agregarEntidadObservadora method, of class Intz_CentroObservado.
     */
    @Test
    public void testAgregarEntidadObservadora() {
        System.out.println("agregarEntidadObservadora");
        EntidadCNT mientidad = new EntidadCNT();
        Intz_CentroObservado instance = new Intz_CentroObservadoImpl();
        instance.agregarEntidadObservadora(mientidad);
        assertEquals(mientidad.getNombre(), "CNT"); 
    }
    /**
     * Test of eliminarEntidadObservadora method, of class Intz_CentroObservado.
     */
    @Test
    public void testEliminarEntidadObservadora() {
        System.out.println("eliminarEntidadObservadora");
        Intz_EntidadCooperativa_Observador mientidad = null;
        Intz_CentroObservado instance = new Intz_CentroObservadoImpl();
        instance.eliminarEntidadObservadora(mientidad);
        assertEquals(mientidad, null);
    }
    /**
     * Test of notificar method, of class Intz_CentroObservado.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        Intz_CentroObservado instance = new Intz_CentroObservadoImpl();
        String expResult = "notificacion exitosa";
        String result = instance.notificar();
        assertEquals(expResult, result);   
    }

    public class Intz_CentroObservadoImpl implements Intz_CentroObservado {
        public void agregarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
        }
        public void eliminarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
        }
        public String notificar() {
            return "notificacion exitosa";
        }
    }
}