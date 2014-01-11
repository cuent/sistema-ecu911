/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public interface Intz_CentroObservado {

    public void agregarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad);
    public void eliminarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad);
    public String notificar();
}
