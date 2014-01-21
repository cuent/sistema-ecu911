/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class ValidaTextoExcepcionTest {
    String saludo;
    public ValidaTextoExcepcionTest() {
    }
    
    @Before
    public void setUp() {
        saludo="";
    }

    @Test(expected=ValidaTextoExcepcion.class)
    public void testSomeMethod() {
        
        if (saludo!=""){
            System.out.print("hola como vas");
        }else {
            throw new ValidaTextoExcepcion("el texto esta vacio");
        }
    }
}
