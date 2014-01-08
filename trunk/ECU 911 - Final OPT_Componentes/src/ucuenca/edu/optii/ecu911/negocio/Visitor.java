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
public interface Visitor {

    public String visitar(EntidadBomberos bomberos);
    public String visitar (EntidadCNT cnt);
    public String visitar (EntidadFuerzasArmadas fuerzasArmadas);
    public String visitar(EntidadPolicia policia);
    public String visitar(EntidadGestionRiesgos gestionRiesgos);
    public String visitar(EntidadCruzRoja cruzRoja);
}
