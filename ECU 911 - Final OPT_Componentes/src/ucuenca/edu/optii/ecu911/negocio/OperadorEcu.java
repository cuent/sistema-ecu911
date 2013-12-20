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
            Logger.getLogger(OperadorEcu.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex.getMessage());
           return false;
        }  
    }
        public void buscar() {
        try {
            OperadorEcu aux;
            OperadorEcuDB usuarioDB = new OperadorEcuDB();
            aux = usuarioDB.buscar(this.cedula);
            setNombres(aux.getNombres());
            setSueldo(aux.getSueldo());
            setUsuario(aux.getUsuario());
            setPassw(aux.getPassw());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existe esa id");
        } 
    }
}
