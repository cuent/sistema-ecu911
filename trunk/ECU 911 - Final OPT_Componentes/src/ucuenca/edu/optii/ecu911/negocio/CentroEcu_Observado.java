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
    String key = "";
    String ciudad;
    String cadena = "";
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
    public String notificar(String incidente) {
        observadores.clear();
        CentroEcu_Observado c = new CentroEcu_Observado();
        if (incidente.contains("incendio forestal")) {
            key = "incendio forestal";
            c.agregarEntidadObservadora(new EntidadBomberos());
            c.agregarEntidadObservadora(new EntidadCruzRoja());
            c.agregarEntidadObservadora(new EntidadGestionRiesgos());
            c.agregarEntidadObservadora(new EntidadPolicia());
        } else if (incidente.contains("asalto sin lesion")) {
            key = "asalto sin lesion";
            c.agregarEntidadObservadora(new EntidadGestionRiesgos());
            c.agregarEntidadObservadora(new EntidadPolicia());
        } else if (incidente.contains("asalto con lesion")) {
            key = "asalto con lesion";
            c.agregarEntidadObservadora(new EntidadCruzRoja());
            c.agregarEntidadObservadora(new EntidadGestionRiesgos());
            c.agregarEntidadObservadora(new EntidadPolicia());
        } else if (incidente.contains("incendio hogar")) {
            key = "incendio hogar";
            c.agregarEntidadObservadora(new EntidadBomberos());
            c.agregarEntidadObservadora(new EntidadCruzRoja());
            c.agregarEntidadObservadora(new EntidadPolicia());
        } else if (incidente.contains("abandono nino")) {
            key = "abandono nino";
            c.agregarEntidadObservadora(new EntidadCruzRoja());
            c.agregarEntidadObservadora(new EntidadGestionRiesgos());
            c.agregarEntidadObservadora(new EntidadPolicia());
        } else if (incidente.contains("alerta terrorista")) {
            key = "alerta terrorista";
            c.agregarEntidadObservadora(new EntidadBomberos());
            c.agregarEntidadObservadora(new EntidadCruzRoja());
            c.agregarEntidadObservadora(new EntidadFuerzasArmadas());
            c.agregarEntidadObservadora(new EntidadPolicia());
        } else if (incidente.contains("secuestro")) {
            key = "secuestro";
            c.agregarEntidadObservadora(new EntidadFuerzasArmadas());
            c.agregarEntidadObservadora(new EntidadPolicia());
            c.agregarEntidadObservadora(new EntidadGestionRiesgos());
        }

        cadena = "Para el incidente de: " + key + "\n";
        for (int i = 0; i < observadores.size(); i++) {
            cadena = cadena + observadores.get(i).recibir_alarma() + "\n";
        }
        return cadena;
    }
}
