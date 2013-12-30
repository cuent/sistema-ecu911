/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.util.List;

/**
 *
 * @author cuent
 */
public class Centro_Local extends CentroEcu_Observado {

    String nombre;

    public String getNombre() {
        return "Centro ECU 911 Local";
    }

    @Override
    public String notificar(String incidentes) {
        return getNombre() + "\n" + super.notificar(incidentes)+ "\n"; //To change body of generated methods, choose Tools | Templates.
    }
}
