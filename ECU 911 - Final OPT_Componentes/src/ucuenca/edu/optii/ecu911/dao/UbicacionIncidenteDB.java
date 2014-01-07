/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.SQLException;
import ucuenca.edu.optii.ecu911.negocio.Ubicacion_Incidente;

/**
 *
 * @author cuent
 */
public class UbicacionIncidenteDB {

    public boolean grabar(Ubicacion_Incidente ubicacionIncidente) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO ubicacion_incidente(calle_principal, interseccion, referencia, ciudad, tipo_incidenteid) "
                + "VALUES ('"+ubicacionIncidente.getCalle_principal()+"', 'S/D', '"+ubicacionIncidente.getReferencia_ubicacion()+"', "
                + "'"+ubicacionIncidente.getCiudad()+"',"+ubicacionIncidente.getMitipo().getId()+");";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
}
