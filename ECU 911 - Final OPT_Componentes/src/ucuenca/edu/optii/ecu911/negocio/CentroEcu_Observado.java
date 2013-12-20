/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucuenca.edu.optii.ecu911.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuent
 */
public class CentroEcu_Observado implements Intz_CentroObservado {
    int id;
    String ciudad;
 private static List<Intz_EntidadCooperativa_Observador> observadores = new ArrayList<Intz_EntidadCooperativa_Observador>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Intz_EntidadCooperativa_Observador> getObservadores() {
        return observadores;
    }

    public static void setObservadores(List<Intz_EntidadCooperativa_Observador> observadores) {
        CentroEcu_Observado.observadores = observadores;
    }
   

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void agregarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
         observadores.add(mientidad);
    }

    @Override
    public void eliminarEntidadObservadora(Intz_EntidadCooperativa_Observador mientidad) {
        observadores.remove(mientidad);
    }
     @Override
    public void notificar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
