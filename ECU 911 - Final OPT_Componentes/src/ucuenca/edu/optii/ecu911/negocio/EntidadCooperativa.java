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
public abstract class EntidadCooperativa implements Intz_EntidadCooperativa_Observador{
   int id;
   String ciudad;
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
   
    @Override
    public void recibir_info() {
       
    }

    @Override
    public String recibir_alarma() {
        return "alarma recibida...";
    }

    @Override
    public void generar_reportes_incidente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("");
    }
    
    public boolean grabar(String Ent) {
        try {
            EntidadDB aspfDB = new EntidadDB();
            aspfDB.grabar(this,Ent);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
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
            Logger.getLogger(ex.getMessage());
        }
        return null;
    } 
        public EntidadCooperativa buscar() {
        try {
            EntidadCooperativa aux;
            EntidadDB aspectoDB= new EntidadDB();
            aux = aspectoDB.buscar(this.id);     
            if(aux!=null){
                setId(aux.getId());
                setCiudad(aux.getCiudad());
                setTipo(aux.getTipo());
                setMifono(aux.getMifono());
             return aux;
            }else{       
                 return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return null;
    }
        
    public abstract String aceptar(Visitor visitor);
}