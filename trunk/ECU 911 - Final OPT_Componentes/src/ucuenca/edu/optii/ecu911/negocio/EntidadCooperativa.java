/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author May
 */
public class EntidadCooperativa implements Intz_EntidadCooperativa_Observador{
   int id;
   String ciudad;
   String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   

    @Override
    public void recibir_info() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void recibir_alarma() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void generar_reportes_incidente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
 
}
