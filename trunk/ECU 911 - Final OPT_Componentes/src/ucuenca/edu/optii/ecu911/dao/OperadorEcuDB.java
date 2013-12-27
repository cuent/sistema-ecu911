
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.negocio.CentroEcu_Observado;
import ucuenca.edu.optii.ecu911.negocio.OperadorEcu;
import ucuenca.edu.optii.ecu911.negocio.Rol;



public class OperadorEcuDB {
     public boolean grabar(OperadorEcu usuario) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into operador_ecu values('"+usuario.getCedula()+"', '" +usuario.getUsuario()+"', '" + usuario.getPassw()+"', '"+usuario.getSueldo() +"', '"+usuario.getMicentro()+"', '"+usuario.getMirol()+"', '"+usuario.getNombres()+ "')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
     
  public int modificar(OperadorEcu usuario) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update operador_ecu set usuario ='"  + usuario.getUsuario() + "', passwd ='"  + usuario.getPassw()+ "' where cedula='" + usuario.getCedula()+"'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
  
    public OperadorEcu buscar(OperadorEcu op) throws SQLException {
        OperacionesBase db = new OperacionesBase();
         String query="select * from operador_ecu where usuario='" + op.getUsuario()+"' and passwd='" + op.getPassw()+"'";      
         ResultSet resultado = db.seleccion(query);
         OperadorEcu usuario=null;
     
        if (resultado!=null&&resultado.next()!=false){
            usuario = new OperadorEcu();
            usuario.setCedula(resultado.getString(1));           
            usuario.setUsuario(resultado.getString(2));
        } 
        db.cerrarConexion();
        return usuario;
    } 
     
    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from operador_ecu ";
        ResultSet resultado = db.seleccion(query);
        OperadorEcu usuario=null;
        
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            usuario = new OperadorEcu();
            CentroEcu_Observado centro=new CentroEcu_Observado();
            Rol unrol=new Rol();
            
            usuario.setCedula(resultado.getString(1));           
            usuario.setUsuario(resultado.getString(2));
            usuario.setSueldo(resultado.getDouble(4));
            centro.setId(resultado.getInt(5));
            usuario.setMicentro(centro);
         
            unrol.setId(resultado.getInt(6));
            usuario.setMirol(unrol);
            usuario.setNombres(resultado.getString(7));
            
            todos.add(usuario);
        }
        db.cerrarConexion();
        return todos;
    }
    
    

}
