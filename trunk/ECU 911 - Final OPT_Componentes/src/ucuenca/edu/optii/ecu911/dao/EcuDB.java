/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author May
 */
public class EcuDB {
      public String buscar(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from centro_ecu where id='" + ide + "'";
        
        ResultSet resultado = db.seleccion(query);
           String miAspecto=null;
        if (resultado!=null && resultado.next()!=false) {
            miAspecto = new String();
            miAspecto=(resultado.getString(2));   
        }
        db.cerrarConexion();
        return miAspecto;
  }
}
