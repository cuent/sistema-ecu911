/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.OperadorEcuDB;

/**
 *
 * @author May
 */
public class OperadorEcu extends Persona{
 String usuario;
 String passw;
 double sueldo;
 CentroEcu_Observado micentro;
 Rol mirol;

    public Rol getMirol() {
        return mirol;
    }

    public void setMirol(Rol mirol) {
        this.mirol = mirol;
    }

    public CentroEcu_Observado getMicentro() {
        return micentro;
    }

    public void setMicentro(CentroEcu_Observado micentro) {
        this.micentro = micentro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
     
    public void loguearse(){
    }
    
    public void atenderLlamada(){
    }
    public void rastrearLlamada(){
    }   
    public void recibirDatosIncidente(){
    }
    
    public void validarIncidente(){
    }
    
    public void lanzarAlarma(){
    }
    
       public boolean grabar() {
        try {
            OperadorEcuDB aspfDB = new OperadorEcuDB();
            aspfDB.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger( ex.getMessage());
           return false;
        }  
    }
        
        public boolean buscarPorCedula() {
        try {
            OperadorEcu aux;
            OperadorEcuDB aspectoDB = new OperadorEcuDB();
            aux = aspectoDB.buscarXid(this);
            if(aux!=null){
             setCedula(aux.getCedula());
             setUsuario(aux.getUsuario());
             setNombres(aux.getNombres());
             setMicentro(aux.getMicentro());
             return true;
            }else{
                 Logger.getLogger("Error al buscar, usuario no existe"); 
                return false;
            }
            
        } catch (SQLException ex) {
             Logger.getLogger(null, ex.getMessage());
        }
        return false;
    }
       
     public boolean buscar() {
        try {
            OperadorEcu aux;
            OperadorEcuDB aspectoDB = new OperadorEcuDB();
            aux = aspectoDB.buscar(this);
            if(aux!=null){
             setCedula(aux.getCedula());
             setUsuario(aux.getUsuario());
             setNombres(aux.getNombres());
             setMicentro(aux.getMicentro());
             return true;
            }else{
                  return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return false;
    }
}