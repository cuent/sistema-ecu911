/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.TipoIncidente;
import ucuenca.edu.optii.ecu911.negocio.EntidadCooperativa;
import ucuenca.edu.optii.ecu911.negocio.Entidad_TipIncidente;
import ucuenca.edu.optii.ecu911.negocio.Visitor;

/**
 *
 * @author May
 */
public class Entidad_TipoIncDB {

    public boolean grabar(int inc, int ent) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into entidad_Tipincidente values('" + ent + "','" + inc + "')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from entidad_Tipincidente ";
        ResultSet resultado = db.seleccion(query);
        Entidad_TipIncidente unobj = null;

        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            unobj = new Entidad_TipIncidente();
            EntidadCooperativa ent = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };
            TipoIncidente tip = new TipoIncidente();

            ent.setId(resultado.getInt(1));
            unobj.setMientidad(ent);

            tip.setId(resultado.getInt(2));
            unobj.setMiTipoIn(tip);

            todos.add(unobj);
        }
        db.cerrarConexion();
        return todos;
    }

    public ArrayList buscar(int ide) throws SQLException {//buscar tipos de incidentes que acepta cierta entidad cooperativa 
        OperacionesBase db = new OperacionesBase();
        String query = "select * from entidad_Tipincidente where identidad=" + ide;
        //String query="select * from entidad_Tipincidente where identidad='" + ide + "'";

        ResultSet resultado = db.seleccion(query);
        Entidad_TipIncidente unobj = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            unobj = new Entidad_TipIncidente();
            EntidadCooperativa ent = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };
            TipoIncidente tip = new TipoIncidente();

            ent.setId(resultado.getInt(1));
            unobj.setMientidad(ent);

            tip.setId(resultado.getInt(2));
            unobj.setMiTipoIn(tip);

            todos.add(unobj);
        }
        db.cerrarConexion();
        return todos;
    }
}
