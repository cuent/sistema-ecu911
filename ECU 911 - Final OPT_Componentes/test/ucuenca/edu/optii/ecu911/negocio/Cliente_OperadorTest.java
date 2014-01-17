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
public class Cliente_OperadorTest {
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Cliente_Operador instance = new Cliente_Operador();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);    
    }

    /**
     * Test of setFecha method, of class Cliente_Operador.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Cliente_Operador instance = new Cliente_Operador();
        instance.setFecha(fecha);
      assertEquals(fecha,  instance.getFecha());
    }

    /**
     * Test of getMiclient method, of class Cliente_Operador.
     */
    @Test
    public void testGetMiclient() {
        System.out.println("getMiclient");
        Cliente_Operador instance = new Cliente_Operador();
        Cliente expResult = null;
        Cliente result = instance.getMiclient();
        assertEquals(expResult, result);      
    }

    /**
     * Test of setMiclient method, of class Cliente_Operador.
     */
    @Test
    public void testSetMiclient() {
        System.out.println("setMiclient");
        Cliente miclient = null;
        Cliente_Operador instance = new Cliente_Operador();
        instance.setMiclient(miclient);
        assertEquals(instance.getMiclient(), null);
    }

    /**
     * Test of getMiOperador method, of class Cliente_Operador.
     */
    @Test
    public void testGetMiOperador() {
        System.out.println("getMiOperador");
        Cliente_Operador instance = new Cliente_Operador();
        OperadorEcu expResult = null;
        OperadorEcu result = instance.getMiOperador();
        assertEquals(expResult, result);      
    }

    /**
     * Test of setMiOperador method, of class Cliente_Operador.
     */
    @Test
    public void testSetMiOperador() {
        System.out.println("setMiOperador");
        OperadorEcu miOperador = null;
        Cliente_Operador instance = new Cliente_Operador();
        instance.setMiOperador(miOperador);
        assertEquals(instance.getMiOperador(), miOperador);
    }
}
