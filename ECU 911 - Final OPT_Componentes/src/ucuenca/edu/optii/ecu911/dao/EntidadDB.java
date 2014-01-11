package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.EntidadCooperativa;
import ucuenca.edu.optii.ecu911.negocio.Telefono;
import ucuenca.edu.optii.ecu911.negocio.Visitor;

/**
 *
 * @author May
 */
public class EntidadDB {

    public boolean grabar(EntidadCooperativa unp, String tipo) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into entidad_cooperativa(ciudad,tipo_entidad, id_fono) values('" + unp.getCiudad() + "', '" + tipo + "', '" + unp.getMifono().getId() + "')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }

    public int modificar(EntidadCooperativa unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "update entidad_cooperativa set ciudad ='" + unp.getCiudad() + "' where id='" + unp.getId() + "'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from entidad_cooperativa ";
        ResultSet resultado = db.seleccion(query);
        EntidadCooperativa unaent = null;

        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            unaent = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };
            Telefono unt = new Telefono();
            unaent.setId(resultado.getInt(1));
            unaent.setCiudad(resultado.getString(2));
            unaent.setTipo(resultado.getString(3));
            unt.setId(resultado.getInt(4));
            unaent.setMifono(unt);
            todos.add(unaent);
        }
        db.cerrarConexion();
        return todos;
    }

    public ArrayList listarDisponibles() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from (select id from entidad_cooperativa except select entidad_cooperativaid from operador_entidad)tabla";
        ResultSet resultado = db.seleccion(query);
        EntidadCooperativa unaent = null;

        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            unaent = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };

            unaent.setId(resultado.getInt(1));
            todos.add(unaent);
        }
        db.cerrarConexion();
        return todos;
    }

    public EntidadCooperativa buscar(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from entidad_cooperativa where id='" + ide + "'";

        ResultSet resultado = db.seleccion(query);
        EntidadCooperativa miAspecto = null;
        if (resultado != null && resultado.next() != false) {
            miAspecto = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };
            miAspecto.setId(resultado.getInt(1));
            miAspecto.setCiudad(resultado.getString(2));
            miAspecto.setTipo(resultado.getString(3));
            Telefono tlf = new Telefono();
            tlf.setId(resultado.getInt(4));
            miAspecto.setMifono(tlf);
        }
        db.cerrarConexion();
        return miAspecto;
    }

    public String buscarHijoEntidad(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from entidad_cooperativa where id='" + ide + "'";
        ResultSet resultado = db.seleccion(query);
        String HijoEntidad = null;
        if (resultado != null && resultado.next() != false) {
            HijoEntidad = resultado.getString(3);
        }
        db.cerrarConexion();
        return HijoEntidad;
    }
}
