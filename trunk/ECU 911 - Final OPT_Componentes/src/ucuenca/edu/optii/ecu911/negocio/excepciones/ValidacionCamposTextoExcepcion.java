/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

import javax.swing.JFrame;
public class ValidacionCamposTextoExcepcion extends RuntimeException {

    public ValidacionCamposTextoExcepcion(JFrame frame,String mensaje) {
     System.out.print(mensaje); 
    }
}