/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

import javax.swing.JFrame;

/**
 *
 * @author May
 */
public class ValidaDatoInexistenteExcepcion extends RuntimeException{

    public ValidaDatoInexistenteExcepcion(JFrame frame, String message) {
         System.out.print(message);
    }
    
}
