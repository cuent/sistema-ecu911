/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public class EntidadPolicia extends EntidadCooperativa implements Visitable {

    private String nombre = "Policia";

    @Override
    public String recibir_alarma() {
        super.recibir_alarma(); //To change body of generated methods, choose Tools | Templates.

        return "Policia en Camino...";

    }

    @Override
    public String aceptar(Visitor visitor) {
        return visitor.visitar(this);
    }

    public String getNombre() {
        return nombre;
    }

}
