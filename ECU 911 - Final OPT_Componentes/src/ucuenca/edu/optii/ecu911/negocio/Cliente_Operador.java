/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author May
 */
public class Cliente_Operador {
    Date fecha;
    Cliente miclient;
    OperadorEcu miOperador;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getMiclient() {
        return miclient;
    }

    public void setMiclient(Cliente miclient) {
        this.miclient = miclient;
    }

    public OperadorEcu getMiOperador() {
        return miOperador;
    }

    public void setMiOperador(OperadorEcu miOperador) {
        this.miOperador = miOperador;
    }
    

}
