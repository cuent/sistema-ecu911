/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.TipoIncidente;

/**
 *
 * @author May
 */
public class TipoIncidenteDB {
 public boolean grabar(TipoIncidente unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into tipo_incidente(descripcion) values('"+unp.getDescripcion()+"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
     
  public int modificar(TipoIncidente unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update tipo_incidente set descripcion ='"  + unp.getDescripcion() + "' where id='" + unp.getId()+"'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from tipo_incidente ";
        ResultSet resultado = db.seleccion(query);
        TipoIncidente unperm=null;
        
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            unperm = new TipoIncidente();
            unperm.setId(resultado.getInt(1));           
            unperm.setDescripcion(resultado.getString(2));                  
            todos.add(unperm);
        }
        db.cerrarConexion();
        return todos;
    }
    
    public TipoIncidente buscar(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from tipo_incidente where id='" + ide + "'";
        
        ResultSet resultado = db.seleccion(query);
           TipoIncidente mitelf=null;
        if (resultado!=null && resultado.next()!=false) {
            //resultado.next();
            mitelf = new TipoIncidente();
            mitelf.setId(resultado.getInt(1));
            mitelf.setDescripcion(resultado.getString(2));
        }
        db.cerrarConexion();
        return mitelf;
  }   
}
