/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public class E_Disponible implements Intz_EstadosTelefono{

    @Override
    public String SuspenderTelefono(Telefono tel) {
         return "Telefono Suspendido";
    }

    @Override
    public String OcuparTelefono(Telefono tel) {
         return "Telefono Ocupado";
    }

    @Override
    public String EsperarTelefono(Telefono tel) {
         return "Telefono en Espera";
    }

    @Override
    public String LiberarTelefono(Telefono tel) {
        return "Telefono Disponible";
    }

  
}