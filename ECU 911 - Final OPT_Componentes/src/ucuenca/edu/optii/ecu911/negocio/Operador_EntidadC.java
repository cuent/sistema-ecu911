/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public class Operador_EntidadC extends Persona{
  String correo_el;
 double sueldo;   
 EntidadCooperativa mientidad;

    public String getCorreo_el() {
        return correo_el;
    }

    public void setCorreo_el(String correo_el) {
        this.correo_el = correo_el;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public EntidadCooperativa getMientidad() {
        return mientidad;
    }

    public void setMientidad(EntidadCooperativa mientidad) {
        this.mientidad = mientidad;
    }
 
}
