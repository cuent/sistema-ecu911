/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

public class ValidaTextoExcepcion extends RuntimeException{
     public ValidaTextoExcepcion(String mensaje) {
     System.out.print(mensaje); 
     }
}
