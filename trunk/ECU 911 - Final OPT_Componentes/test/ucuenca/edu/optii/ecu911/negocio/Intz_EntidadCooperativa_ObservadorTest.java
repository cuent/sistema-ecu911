package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
/**
 *
 * @author May
 */
public class Intz_EntidadCooperativa_ObservadorTest {
    /**
     * Test of recibir_alarma method, of class Intz_EntidadCooperativa_Observador.
     */
    @Test
    public void testRecibir_alarma() {
        System.out.println("recibir_alarma");
        Intz_EntidadCooperativa_Observador instance = new Intz_EntidadCooperativa_ObservadorImpl();
        String expResult = "alarma recibida";
        String result = instance.recibir_alarma();
        assertEquals(expResult, result);
    }

    /**
     * Test of generar_reportes_incidente method, of class Intz_EntidadCooperativa_Observador.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testGenerar_reportes_incidente() {
        System.out.println("generar_reportes_incidente");
        EntidadCooperativa instance = new EntidadPolicia();
        instance.generar_reportes_incidente();
    }
    /**
     * Test of actualizar method, of class Intz_EntidadCooperativa_Observador.
     */
    @Ignore
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Intz_EntidadCooperativa_Observador instance = new Intz_EntidadCooperativa_ObservadorImpl();
        instance.actualizar();
    }

    public class Intz_EntidadCooperativa_ObservadorImpl implements Intz_EntidadCooperativa_Observador {
        @Override
        public void recibir_info() {
        }
        @Override
        public String recibir_alarma() {
            return "alarma recibida";
        }
        public void generar_reportes_incidente() {
        }
        public void actualizar() {
        }
    }
}
