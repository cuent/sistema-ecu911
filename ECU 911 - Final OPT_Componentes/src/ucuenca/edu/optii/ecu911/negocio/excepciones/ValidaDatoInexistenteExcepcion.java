/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author May
 */
public class ValidaDatoInexistenteExcepcion extends RuntimeException{

    public ValidaDatoInexistenteExcepcion(JFrame frame, String message) {
         JOptionPane.showMessageDialog(frame, message,"SITEMA ECU 911",JOptionPane.WARNING_MESSAGE );
    }
    
}
