/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio.excepciones;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cuent
 */
public class ExcepcionVerificarPersonaAfectada extends RuntimeException {

    public ExcepcionVerificarPersonaAfectada(JFrame frame) {
        JOptionPane.showMessageDialog(frame, "Seleccione un Cliente");

    }

}
