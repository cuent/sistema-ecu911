/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.Date;

/**
 *
 * @author May
 */
public class Cliente_Incidente {
    Cliente micli;
    Ubicacion_Incidente mincident;
    Date fecha;

    public Cliente getMicli() {
        return micli;
    }

    public void setMicli(Cliente micli) {
        this.micli = micli;
    }

    public Ubicacion_Incidente getMincident() {
        return mincident;
    }

    public void setMincident(Ubicacion_Incidente mincident) {
        this.mincident = mincident;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
