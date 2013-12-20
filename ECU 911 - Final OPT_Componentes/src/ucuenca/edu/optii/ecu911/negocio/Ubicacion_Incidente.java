package ucuenca.edu.optii.ecu911.negocio;

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
    
}
