package ucuenca.edu.optii.ecu911.negocio;
import java.sql.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class Cliente_IncidenteTest {
   
    /**
     * Test of getMicli method, of class Cliente_Incidente.
     */
    @Test
    public void testGetMicli() {
        System.out.println("getMicli");
        Cliente_Incidente instance = new Cliente_Incidente();
        Cliente expResult = null;
        Cliente result = instance.getMicli();
        assertEquals(expResult, result);    
    }

    /**
     * Test of setMicli method, of class Cliente_Incidente.
     */
    @Test
    public void testSetMicli() {
        System.out.println("setMicli");
        Cliente micli = new Cliente();
        micli.cedula="01020304";
        micli.nombres="andrea mendez";
        Cliente_Incidente instance = new Cliente_Incidente();
        instance.setMicli(micli);
        assertEquals(micli, instance.getMicli()); 
    }

    /**
     * Test of getMincident method, of class Cliente_Incidente.
     */
    @Test
    public void testGetMincident() {
        System.out.println("getMincident");
        Cliente_Incidente instance = new Cliente_Incidente();
        Ubicacion_Incidente expResult = new Ubicacion_Incidente();
        expResult.ciudad="Cuenca";
        expResult.calle_principal="calle 1";
        expResult.interseccion="calle 2";
        expResult.referencia_ubicacion="cerca del mall";
        instance.setMincident(expResult);
        Ubicacion_Incidente result = instance.getMincident();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setMincident method, of class Cliente_Incidente.
     */
    @Test
    public void testSetMincident() {
        System.out.println("setMincident");
        Ubicacion_Incidente mincident = null;
        Cliente_Incidente instance = new Cliente_Incidente();
        instance.setMincident(mincident);      
        assertEquals(instance.getMincident(), mincident);
    }

    /**
     * Test of getFecha method, of class Cliente_Incidente.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Cliente_Incidente instance = new Cliente_Incidente();
        instance.setFecha(null);
        Date result = instance.getFecha();
        assertEquals(result, result);
    }

    /**
     * Test of setFecha method, of class Cliente_Incidente.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Cliente_Incidente instance = new Cliente_Incidente();
        instance.setFecha(fecha);
        assertEquals(fecha, instance.getFecha());
    }
}