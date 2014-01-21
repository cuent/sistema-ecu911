/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

public class ValidaDatoInexistenteExcepcion extends RuntimeException{
    public ValidaDatoInexistenteExcepcion( String message) {
         System.out.print(message);
    }
    
}
