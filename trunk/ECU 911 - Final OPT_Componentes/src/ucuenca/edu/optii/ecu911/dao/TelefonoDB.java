/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.negocio.Telefono;

/**
 *
 * @author May
 */
public class TelefonoDB {
     public boolean grabar(Telefono unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into telefono(tipo,numero) values('"+unp.getTipo()+"','" + unp.getNumero() +"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
     
  public int modificar(Telefono unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update telefono set tipo ='"  + unp.getTipo() + "' where id='" + unp.getId()+"'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
 public ArrayList listarDisponibles() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from telefono inner join (select id from telefono except (select id_fono from entidad_cooperativa union select id_fono from cliente))as valido using (id)";
        ResultSet resultado = db.seleccion(query);
        Telefono unperm=null;
        ArrayList todos=new ArrayList();
       
        while (resultado.next()) {
            unperm = new Telefono();
            unperm.setId(resultado.getInt(1));           
            unperm.setTipo(resultado.getString(2));     
            unperm.setNumero(resultado.getString(3));             
            todos.add(unperm);
        }
        db.cerrarConexion();
        return todos;
    }
    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from telefono ";
        ResultSet resultado = db.seleccion(query);
        Telefono unperm=null;
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            unperm = new Telefono();
            unperm.setId(resultado.getInt(1));           
            unperm.setTipo(resultado.getString(2));     
            unperm.setNumero(resultado.getString(3));               
            todos.add(unperm);
        }
        db.cerrarConexion();
        return todos;
    }
    public Telefono buscarNumero(String num) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from telefono where numero='" + num + "'";
        ResultSet resultado = db.seleccion(query);
           Telefono mitelf=null;
        if (resultado!=null && resultado.next()!=false) {
            mitelf = new Telefono();
            mitelf.setId(resultado.getInt(1));
            mitelf.setTipo(resultado.getString(2));
            mitelf.setNumero(resultado.getString(3));
        }
        db.cerrarConexion();
        return mitelf;
  }
    public Telefono buscar(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from telefono where id='" + ide + "'";
        
        ResultSet resultado = db.seleccion(query);
           Telefono mitelf=null;
        if (resultado!=null && resultado.next()!=false) {
            mitelf = new Telefono();
            mitelf.setId(resultado.getInt(1));
            mitelf.setNumero(resultado.getString(3));
        }
        db.cerrarConexion();
        return mitelf;
  }
}
