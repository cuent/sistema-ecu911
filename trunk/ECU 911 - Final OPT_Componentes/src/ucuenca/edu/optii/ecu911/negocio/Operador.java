/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public class Operador extends Persona{
 String usuario;
 String passw;
 double sueldo;

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
}
