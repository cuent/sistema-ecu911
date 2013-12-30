/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.Entidad_TipoIncDB;
import ucuenca.edu.optii.ecu911.negocio.Entidad_TipIncidente;

/**
 *
 * @author May
 */
public class Entidad_TipIncidente {
    EntidadCooperativa mientidad;
    TipoIncidente miTipoIn;

    public EntidadCooperativa getMientidad() {
        return mientidad;
    }

    public void setMientidad(EntidadCooperativa mientidad) {
        this.mientidad = mientidad;
    }

    public TipoIncidente getMiTipoIn() {
        return miTipoIn;
    }

    public void setMiTipoIn(TipoIncidente miTipoIn) {
        this.miTipoIn = miTipoIn;
    }
    
     public boolean grabar(int inc, int ent) {
        try {
            Entidad_TipoIncDB aspfDB = new Entidad_TipoIncDB();
            aspfDB.grabar(inc, ent);
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(Entidad_TipIncidente.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
}
