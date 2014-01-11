package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.EntidadCooperativa;
import ucuenca.edu.optii.ecu911.negocio.Operador_EntidadC;
import ucuenca.edu.optii.ecu911.negocio.Visitor;

/**
 *
 * @author May
 */
public class OperadorEntidadDB {

    public boolean grabar(Operador_EntidadC usuario) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into operador_entidad values('" + usuario.getCedula() + "', '" + usuario.getCorreo_el() + "', '" + usuario.getSueldo() + "', '" + usuario.getMientidad().getId() + "')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }

    public Operador_EntidadC buscar(Operador_EntidadC op) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from operador_entidad where cedula='" + op.getCedula() + "'";
        ResultSet resultado = db.seleccion(query);
        Operador_EntidadC usuario = null;

        if (resultado != null && resultado.next() != false) {
            usuario = new Operador_EntidadC();
            usuario.setCedula(resultado.getString(1));
            usuario.setCorreo_el(resultado.getString(2));
        }
        db.cerrarConexion();
        return usuario;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from operador_entidad ";
        ResultSet resultado = db.seleccion(query);
        Operador_EntidadC usuario = null;

        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            usuario = new Operador_EntidadC();
            EntidadCooperativa mientidad = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };
            usuario.setCedula(resultado.getString(1));
            usuario.setCorreo_el(resultado.getString(2));
            usuario.setSueldo(resultado.getDouble(3));
            mientidad.setId(resultado.getInt(4));
            usuario.setMientidad(mientidad);
            todos.add(usuario);
        }
        db.cerrarConexion();
        return todos;
    }
}
