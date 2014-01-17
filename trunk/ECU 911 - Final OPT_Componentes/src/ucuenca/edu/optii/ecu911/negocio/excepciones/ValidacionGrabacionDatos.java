/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ValidacionGrabacionDatos extends RuntimeException{
    public ValidacionGrabacionDatos(JFrame frame, String message) {
          System.out.print(message); 
    }
      
}
