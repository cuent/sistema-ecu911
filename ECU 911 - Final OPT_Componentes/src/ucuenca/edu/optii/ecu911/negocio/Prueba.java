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
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CentroEcu_Observado c=new CentroEcu_Observado();
        c.agregarEntidadObservadora(new EntidadBomberos());
        c.agregarEntidadObservadora(new EntidadCNT());
        c.agregarEntidadObservadora(new EntidadCruzRoja());
        c.agregarEntidadObservadora(new EntidadFuerzasArmadas());
        c.agregarEntidadObservadora(new EntidadGestionRiesgos());
        c.agregarEntidadObservadora(new EntidadPolicia());

        
    }
    
}
