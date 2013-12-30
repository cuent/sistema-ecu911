/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.ClienteDB;

/**
 *
 * @author May
 */
public class Cliente extends Persona{
    Telefono mifono;

    public Telefono getMifono() {
        return mifono;
    }

    public void setMifono(Telefono mifono) {
        this.mifono = mifono;
    }
    
    public void llamar(){
    }
    
    
      public boolean grabar() {
        try {
            ClienteDB unrol = new ClienteDB();
            unrol.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
      
       public boolean buscar() {
        try {
            Cliente aux;
            ClienteDB aspectoDB = new ClienteDB();
            aux = aspectoDB.buscarTelefono(this.mifono.id);
            
            if(aux!=null){
             setCedula(aux.getCedula());
             setNombres(aux.getNombres());   
             return true;
            }else{       
                 return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
    public boolean buscarCedula() {
        try {
            Cliente aux;
            ClienteDB aspectoDB = new ClienteDB();
            aux = aspectoDB.buscarCedula(this.cedula);

            if (aux != null) {
                setCedula(aux.getCedula());
                setNombres(aux.getNombres());
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
