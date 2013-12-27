package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.Permiso;
import ucuenca.edu.optii.ecu911.negocio.Rol;
import ucuenca.edu.optii.ecu911.negocio.Rol_Permiso;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author May
 */
public class RolPermisoDC {
    public class PermisoDB {
        
    }
      public boolean grabar(Rol_Permiso unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into permiso_rol values('"+unp.getPermisoId()+"','" + unp.getRolid() +"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    public ArrayList buscar(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from permiso_rol where idrol='" + ide + "'";
        ResultSet resultado = db.seleccion(query);
     
        
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
         
             todos.add(resultado.getInt(1));           
           
        }
        db.cerrarConexion();
        return todos;
    }
}
