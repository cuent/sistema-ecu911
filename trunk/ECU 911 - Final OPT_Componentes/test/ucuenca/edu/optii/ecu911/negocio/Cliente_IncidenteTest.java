/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Cliente_IncidenteTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

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
        Cliente micli = null;
        Cliente_Incidente instance = new Cliente_Incidente();
        instance.setMicli(micli);
       
    }

    /**
     * Test of getMincident method, of class Cliente_Incidente.
     */
    @Test
    public void testGetMincident() {
        System.out.println("getMincident");
        Cliente_Incidente instance = new Cliente_Incidente();
        Ubicacion_Incidente expResult = null;
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
        
    }

    /**
     * Test of getFecha method, of class Cliente_Incidente.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Cliente_Incidente instance = new Cliente_Incidente();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        
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
       
    }
}
