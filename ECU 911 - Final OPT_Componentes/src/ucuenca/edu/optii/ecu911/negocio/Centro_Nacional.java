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
public class Centro_Nacional extends CentroEcu_Observado{
       String nombre;

    public String getNombre() {
        return "Centro ECU 911 Nacional";
    }

    @Override
    public String notificar(List incidentes) {
        return getNombre()+"\n"+super.notificar(incidentes); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
