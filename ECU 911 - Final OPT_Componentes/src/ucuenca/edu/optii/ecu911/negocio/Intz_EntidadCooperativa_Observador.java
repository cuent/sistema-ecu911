/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public interface Intz_EntidadCooperativa_Observador {
     
     public void recibir_info();
     public String recibir_alarma();
     public void generar_reportes_incidente();
     public void actualizar(); 
     
}
