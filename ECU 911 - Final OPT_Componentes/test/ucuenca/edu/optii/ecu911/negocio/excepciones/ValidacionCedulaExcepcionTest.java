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
public class ValidacionCedulaExcepcionTest {
    String cedula;
    public ValidacionCedulaExcepcionTest() {
    }
    
    @Before
    public void setUp() {
        cedula="010101";
    }
    
    @Test(expected=ValidacionCedulaExcepcion.class)
    public void TestCedulaDigitos() {
       if(cedula.length()!=10){
           throw new ValidacionCedulaExcepcion("la cedula debe tener 10 digitos");
       }
    }

    @Test(expected=ValidacionCedulaExcepcion.class)
    public void TestCedulaInvalida() {
        cedula="0101010101";
        throw new ValidacionCedulaExcepcion("La cedula no es válida");     
    }
    
    
}
