/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucuenca.edu.optii.ecu911.negocio.excepciones;

import javax.swing.JFrame;

public class ExcepcionVerificarDireccionIncidente extends RuntimeException{
    public ExcepcionVerificarDireccionIncidente(JFrame frame) {
                System.out.println("Ingrese la Direccion del Incidente");
    }
    
}
