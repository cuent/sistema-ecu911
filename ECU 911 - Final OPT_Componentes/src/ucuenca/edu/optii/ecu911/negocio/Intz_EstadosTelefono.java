/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public interface Intz_EstadosTelefono {
    public String SuspenderTelefono(Telefono tel);
    public String OcuparTelefono(Telefono tel);
    public String EsperarTelefono(Telefono tel);
    public String LiberarTelefono(Telefono tel);
}
