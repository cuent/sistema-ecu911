package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.UbicacionIncidenteDB;

/**
 *
 * @author May
 */
public class Ubicacion_Incidente {

    String calle_principal;
    String interseccion;
    String referencia_ubicacion;
    String ciudad;
    TipoIncidente mitipo;

    public Ubicacion_Incidente(String calle_principal, String referencia_ubicacion, String ciudad, TipoIncidente mitipo) {
        this.calle_principal = calle_principal;
        this.referencia_ubicacion = referencia_ubicacion;
        this.ciudad = ciudad;
        this.mitipo = mitipo;
    }

    public Ubicacion_Incidente() {
    }

    
    
    public TipoIncidente getMitipo() {
        return mitipo;
    }

    public void setMitipo(TipoIncidente mitipo) {
        this.mitipo = mitipo;
    }

    public String getCalle_principal() {
        return calle_principal;
    }

    public void setCalle_principal(String calle_principal) {
        this.calle_principal = calle_principal;
    }

    public String getInterseccion() {
        return interseccion;
    }

    public void setInterseccion(String interseccion) {
        this.interseccion = interseccion;
    }

    public String getReferencia_ubicacion() {
        return referencia_ubicacion;
    }

    public void setReferencia_ubicacion(String referencia_ubicacion) {
        this.referencia_ubicacion = referencia_ubicacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean grabar() {
        try {
            UbicacionIncidenteDB ubicacionIncidenteDB = new UbicacionIncidenteDB();
            ubicacionIncidenteDB.grabar(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Rol.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

}
