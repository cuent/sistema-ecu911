/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.Permiso;

/**
 *
 * @author May
 */
public class PermisoDB {
      public boolean grabar(Permiso unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into permiso(descripcion) values('"+unp.getDescripcion()+"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
     
  public int modificar(Permiso unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update permiso set descripcion ='"  + unp.getDescripcion() + "' where id='" + unp.getId()+"'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from permiso ";
        ResultSet resultado = db.seleccion(query);
        Permiso unperm=null;
        
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            unperm = new Permiso();
            unperm.setId(resultado.getInt(1));           
            unperm.setDescripcion(resultado.getString(2));               
            todos.add(unperm);
        }
        db.cerrarConexion();
        return todos;
    }
    
    public Permiso buscar(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from permiso where id='" + ide + "'";
        
        ResultSet resultado = db.seleccion(query);
           Permiso miAspecto=null;
        if (resultado!=null && resultado.next()!=false) {
            //resultado.next();
            miAspecto = new Permiso();
            miAspecto.setId(resultado.getInt(1));
            miAspecto.setDescripcion(resultado.getString(2));
        }
        db.cerrarConexion();
        return miAspecto;
  }
 }
 