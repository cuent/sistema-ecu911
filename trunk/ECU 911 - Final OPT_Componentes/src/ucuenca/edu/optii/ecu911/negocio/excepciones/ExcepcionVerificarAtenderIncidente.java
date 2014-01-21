/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucuenca.edu.optii.ecu911.negocio.excepciones;

/**
 *
 * @author cuent
 */
public class ExcepcionVerificarAtenderIncidente extends RuntimeException{

    public ExcepcionVerificarAtenderIncidente() {
                System.out.println("Seleccione un Incidente primero ");
    }
    
}
