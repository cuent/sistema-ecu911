/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.RolPermisoDC;

/**
 *
 * @author May
 */
public class Rol_Permiso {
    int Rolid;
    int PermisoId;

    public int getRolid() {
        return Rolid;
    }

    public void setRolid(int Rolid) {
        this.Rolid = Rolid;
    }

    public int getPermisoId() {
        return PermisoId;
    }

    public void setPermisoId(int PermisoId) {
        this.PermisoId = PermisoId;
    }
    
      public boolean grabar() {
        try {
            RolPermisoDC aspfDB = new RolPermisoDC();
            aspfDB.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Rol_Permiso.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
       public ArrayList buscarPermisos() {
        try {
            ArrayList<Integer> aux;
            RolPermisoDC unrol = new RolPermisoDC();
            aux = unrol.buscar(this.Rolid);
            if(aux!=null){
             return aux;
            }else{
                 JOptionPane.showMessageDialog(null, "Error al buscar, usuario no existe");
                 return null;
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
