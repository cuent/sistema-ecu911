
package ucuenca.edu.optii.ecu911.dao;

import ucuenca.edu.optii.ecu911.negocio.Login;
import ucuenca.edu.optii.ecu911.negocio.OperadorEcu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginDB {
    public boolean grabar(Login login) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into login(id_op_ecu, fecha_i) values('"+login.getUsu().getCedula() +"', '" + login.getFecha_inicio()+ "')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    
    public int modificar(Login login, String fecha) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update login set fecha_f='" + fecha + "' where id='" + login.getId()+"'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    
    public Login buscar(int id) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from login where id =" + id;        
        ResultSet resultado = db.seleccion(query);
        Login login=null;
        OperadorEcu usuario=null;
        if (resultado!=null) {
            resultado.next();
            login = new Login();
            usuario = new OperadorEcu();
            login.setId(resultado.getInt(1));           
            login.setFecha_inicio(resultado.getString(2));
            login.setFecha_fin(resultado.getString(3));
            usuario.setCedula(resultado.getString(4));
            login.setUsu(usuario);
        } 
        db.cerrarConexion();
        return login;        
    }
    
    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from login ";
        ResultSet resultado = db.seleccion(query);
        Login login=null;
        OperadorEcu usuario=null;
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            login = new Login();
            usuario=new OperadorEcu();
            login.setId(resultado.getInt(1));           
            login.setFecha_inicio(resultado.getString(2));
            login.setFecha_fin(resultado.getString(3));
            usuario.setCedula(resultado.getString(4));
            login.setUsu(usuario);
            todos.add(login);
        }
        db.cerrarConexion();
        return todos;
    }
}
