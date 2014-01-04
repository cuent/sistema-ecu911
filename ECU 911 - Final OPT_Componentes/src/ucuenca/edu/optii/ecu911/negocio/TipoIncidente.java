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
import ucuenca.edu.optii.ecu911.dao.TipoIncidenteDB;

/**
 *
 * @author May
 */
public class TipoIncidente {
    int id;
    String descripcion;
    List<EntidadCooperativa> misentidades = new ArrayList<EntidadCooperativa>();

    public List<EntidadCooperativa> getMisentidades() {
        return misentidades;
    }

    public void setMisentidades(List<EntidadCooperativa> misentidades) {
        this.misentidades = misentidades;
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
           TipoIncidenteDB unrol = new TipoIncidenteDB();
            unrol.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Rol.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
      
      public boolean buscarDescripcion() {
        try {
            TipoIncidente aux;
            TipoIncidenteDB unper = new TipoIncidenteDB();
            aux = unper.buscar(this.id);
            if(aux!=null){
             setId(aux.getId());
             setDescripcion(aux.getDescripcion());
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
