/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Logger;
import ucuenca.edu.optii.ecu911.dao.RegistroLlamadasDB;

/**
 *
 * @author May
 */
public class Registro_LLamadas {
   String cedula;
   String telefono;
   String fecha;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   
     public boolean grabar() {
        try {
            RegistroLlamadasDB aspfDB = new RegistroLlamadasDB();
            aspfDB.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
           return false;
        }  
    }
}
