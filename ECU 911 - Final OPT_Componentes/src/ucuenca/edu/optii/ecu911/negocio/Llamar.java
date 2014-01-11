/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuent
 */
public class Llamar {

    private ArrayList lIncidente;
    private ArrayList lista = new ArrayList();
    private CentroEcu_Observado c;

    public Llamar(ArrayList lIncidente, String zona) {
        this.lIncidente = lIncidente;
        switch (zona) {
            case "local":
                c = new Centro_Local();
                lista.add(new Centro_Local().getNombre());
                break;
            case "nacional":
                c = new Centro_Nacional();
                lista.add(new Centro_Nacional().getNombre());
                break;
            case "zonal":
                c = new Centro_Zonal();
                lista.add(new Centro_Zonal().getNombre());
                break;
        }
    }

    public ArrayList alertar() {
        LlamarEntidad llamarEntidad = new LlamarEntidad();
        EntidadFactoryMethod factory = new EntidadFactory();

        for (Object object : lIncidente) {
            EntidadCooperativa entidad = factory.crearEntidad(object.toString());

            c.agregarEntidadObservadora(entidad);
            lista.add(entidad.aceptar(llamarEntidad));
        }
        c.notificar();
        return lista;
    }
}
