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
public class EntidadFactory implements EntidadFactoryMethod {

    @Override
    public EntidadCooperativa crearEntidad(String tipo) {
        switch (tipo) {
            case "Bomberos":
                return new EntidadBomberos();
            case "Policia":
                return new EntidadPolicia();
            case "CNT":
                return new EntidadCNT();
            case "Cruz Roja":
                return new EntidadCruzRoja();
            case "Fuerzas Armadas":
                return new EntidadFuerzasArmadas();
            case "Gestion Riesgos":
                return new EntidadGestionRiesgos();
        }
        return null;
    }

}
