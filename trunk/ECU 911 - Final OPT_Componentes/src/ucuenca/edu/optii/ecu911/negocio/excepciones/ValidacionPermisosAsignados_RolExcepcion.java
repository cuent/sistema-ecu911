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
public class ValidacionPermisosAsignados_RolExcepcion 
extends RuntimeException{

    public ValidacionPermisosAsignados_RolExcepcion(JFrame frame, String message) {
    System.out.print(message); 
    }
    
}
