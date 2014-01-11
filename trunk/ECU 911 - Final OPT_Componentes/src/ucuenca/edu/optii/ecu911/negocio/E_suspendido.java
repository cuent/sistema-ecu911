/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public class E_suspendido implements Intz_EstadosTelefono{

    @Override
    public void SuspenderTelefono(Telefono tel) {
         System.out.print("Telefono Suspendido");
    }

    @Override
    public void OcuparTelefono(Telefono tel) {
         System.out.print("Telefono Ocupado");
    }

    @Override
    public void EsperarTelefono(Telefono tel) {
        System.out.print("Telefono en Espera");
    }

    @Override
    public void LiberarTelefono(Telefono tel) {
        System.out.print("Telefono Disponible");
    }   
}
