/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.PermisoDB;

/**
 *
 * @author May
 */
public class Permiso {
    int id;
    String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     public boolean grabar() {
        try {
            PermisoDB aspfDB = new PermisoDB();
            aspfDB.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
    
}
