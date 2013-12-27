/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.RolDB;

/**
 *
 * @author May
 */
public class Rol {
    int id;
    String descripcion;
    List<Permiso> mispermisos = new ArrayList<Permiso>();

    public List<Permiso> getMispermisos() {
        return mispermisos;
    }

    public void setMispermisos(List<Permiso> mispermisos) {
        this.mispermisos = mispermisos;
    }

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
            RolDB unrol = new RolDB();
            unrol.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Rol.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
     
     public boolean buscarIde() {
        try {
            Rol aux;
            RolDB unrol = new RolDB();
            aux = unrol.buscar(this.descripcion);
            if(aux!=null){
             setId(aux.getId());
             return true;
            }else{
                 JOptionPane.showMessageDialog(null, "Error al buscar, usuario no existe");
                 return false;
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
}
