/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.Registro_LLamadas;

/**
 *
 * @author May
 */
public class RegistroLlamadasDB {
       public boolean grabar(Registro_LLamadas registro) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into registro_llamadas values('"+registro.getCedula() +"', '" + registro.getTelefono() +"', '" + registro.getFecha()+"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from registro_llamadas ";
        ResultSet resultado = db.seleccion(query);
        Registro_LLamadas reg=null;
        
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            reg = new Registro_LLamadas();
            
            reg.setCedula(resultado.getString(1));           
            reg.setTelefono(resultado.getString(2));
            reg.setFecha(resultado.getString(3));
            
            todos.add(reg);
        }
        db.cerrarConexion();
        return todos;
    }
}
