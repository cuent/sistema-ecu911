/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.util.ArrayList;

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
        for (Object object : lIncidente) {
            String entidad = object.toString();
            switch (entidad) {
                case "Bomberos":
                    EntidadBomberos bomberos = new EntidadBomberos();
                    c.agregarEntidadObservadora(bomberos);
                    lista.add(bomberos.aceptar(llamarEntidad));
                    break;
                case "Policia":
                    EntidadPolicia policia = new EntidadPolicia();
                    c.agregarEntidadObservadora(policia);
                    lista.add(policia.aceptar(llamarEntidad));
                    break;
                case "CNT":
                    EntidadCNT cnt = new EntidadCNT();
                    c.agregarEntidadObservadora(cnt);
                    lista.add(cnt.aceptar(llamarEntidad));
                    break;
                case "Cruz Roja":
                    EntidadCruzRoja cruzRoja = new EntidadCruzRoja();
                    c.agregarEntidadObservadora(cruzRoja);
                    lista.add(cruzRoja.aceptar(llamarEntidad));
                    break;
                case "Fuerzas Armadas":
                    EntidadFuerzasArmadas fuerzasArmadas = new EntidadFuerzasArmadas();
                    c.agregarEntidadObservadora(fuerzasArmadas);
                    lista.add(fuerzasArmadas.aceptar(llamarEntidad));
                    break;
                case "Gestion Riesgos":
                    EntidadGestionRiesgos gestionRiesgos = new EntidadGestionRiesgos();
                    c.agregarEntidadObservadora(gestionRiesgos);
                    lista.add(gestionRiesgos.aceptar(llamarEntidad));
                    break;
            }

        }
        c.notificar();
        return lista;
    }
}
