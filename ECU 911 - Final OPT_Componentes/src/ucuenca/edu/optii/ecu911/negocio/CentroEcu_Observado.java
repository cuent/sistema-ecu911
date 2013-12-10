/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author cuent
 */
public class CentroEcu_Observado implements Intz_CentroObservado {
String ciudad;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void agregarEntidadObservadora(EntidadCooperativa mientidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminarEntidadObservadora(EntidadCooperativa mientidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notificar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
