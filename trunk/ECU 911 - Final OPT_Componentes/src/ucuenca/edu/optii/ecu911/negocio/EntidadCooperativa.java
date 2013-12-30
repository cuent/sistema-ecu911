/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.EntidadDB;
import ucuenca.edu.optii.ecu911.dao.TelefonoDB;

/**
 *
 * @author May
 */
public class EntidadCooperativa implements Intz_EntidadCooperativa_Observador{
   int id;
   String ciudad;
   String correo;
   Telefono mifono;
   String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   

    public Telefono getMifono() {
        return mifono;
    }

    public void setMifono(Telefono mifono) {
        this.mifono = mifono;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   

    @Override
    public void recibir_info() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String recibir_alarma() {
        return "";
    }

    @Override
    public void generar_reportes_incidente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean grabar(String Ent) {
        try {
            EntidadDB aspfDB = new EntidadDB();
            aspfDB.grabar(this,Ent);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
    public String buscarEntidadHijo() {
        try {
            String aux;
            EntidadDB aspectoDB= new EntidadDB();
            aux = aspectoDB.buscarHijoEntidad(this.id);
            
            if(aux!=null){  
             return aux;
            }else{       
                 return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Telefono.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
}
