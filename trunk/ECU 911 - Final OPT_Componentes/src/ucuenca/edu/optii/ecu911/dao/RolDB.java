/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.Rol;

/**
 *
 * @author May
 */
public class RolDB {
     public boolean grabar(Rol unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into rol(descripcion) values('"+unp.getDescripcion()+"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
     
  public int modificar(Rol unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update rol set descripcion ='"  + unp.getDescripcion() + "' where id='" + unp.getId()+"'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from rol ";
        ResultSet resultado = db.seleccion(query);
        Rol unperm=null;
        
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            unperm = new Rol();
            unperm.setId(resultado.getInt(1));           
            unperm.setDescripcion(resultado.getString(2));               
            todos.add(unperm);
        }
        db.cerrarConexion();
        return todos;
    }
    
    public Rol buscar(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from rol where id='" + ide + "'";
        
        ResultSet resultado = db.seleccion(query);
           Rol miAspecto=null;
        if (resultado!=null && resultado.next()!=false) {
            //resultado.next();
            miAspecto = new Rol();
            miAspecto.setId(resultado.getInt(1));
            miAspecto.setDescripcion(resultado.getString(2));
        }
        db.cerrarConexion();
        return miAspecto;
  }
}
