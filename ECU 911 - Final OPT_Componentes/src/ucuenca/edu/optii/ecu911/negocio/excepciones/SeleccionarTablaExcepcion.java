/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

public class SeleccionarTablaExcepcion extends RuntimeException {
    public SeleccionarTablaExcepcion(String mensaje) {
       System.out.print(mensaje);
    }   
}
