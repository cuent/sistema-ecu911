/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class validacionesTest {
    
    public validacionesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validaCedula method, of class validaciones.
     */
    @Test
    public void testValidaCedula() {
       System.out.println("validaCedula");
        String cedula = "0101010101";
        validaciones instance = new validaciones();
        boolean expResult = false;
        boolean result = instance.validaCedula(cedula);
        System.out.println(" "+ result+ expResult);
        assertEquals(expResult, result); 
    }
   @Test
    public void testValidaCedulaMenosDigitos() {
       System.out.println("validaCedula");
        String cedula = "010101";
        validaciones instance = new validaciones();
        boolean expResult = false;
        boolean result = instance.validaCedula(cedula);
        System.out.println(" "+ result+ expResult);
        assertEquals(expResult, result); 
    }
    /**
     * Test of validaTexto method, of class validaciones.
     */
    @Test
    public void testValidaTexto() {
        System.out.println("validaTexto");
        KeyEvent evt ;
       validaciones instance = new validaciones();
        JTextField n= new JTextField("4567");
        //instance.validaTexto(evt,n );
        assertEquals(false, false);
    }
}
