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
    public void SuspenderTelefono(Telefono tel);
     public void OcuparTelefono(Telefono tel);
      public void EsperarTelefono(Telefono tel);
       public void LiberarTelefono(Telefono tel);
}
