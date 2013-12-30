/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ucuenca.edu.optii.ecu911.negocio.Cliente;
import ucuenca.edu.optii.ecu911.negocio.Telefono;

/**
 *
 * @author May
 */
public class ClienteDB {

    public boolean grabar(Cliente unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "insert into cliente values('" + unp.getCedula() + "','" + unp.getMifono().getId() + "','" + unp.getNombres() + "')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }

    public int modificar(Cliente unp) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "update cliente set nombres ='" + unp.getNombres() + "' where cedula='" + unp.getCedula() + "'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from cliente ";
        ResultSet resultado = db.seleccion(query);
        Cliente unicl = null;

        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            unicl = new Cliente();
            Telefono untl = new Telefono();

            unicl.setCedula(resultado.getString(1));
            untl.setId(resultado.getInt(2));
            unicl.setMifono(untl);
            unicl.setNombres(resultado.getString(3));
            todos.add(unicl);
        }
        db.cerrarConexion();
        return todos;
    }

    public Cliente buscarTelefono(int ide) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from cliente where id_fono='" + ide + "'";

        ResultSet resultado = db.seleccion(query);
        Cliente mitelf = null;
        if (resultado != null && resultado.next() != false) {
            //resultado.next();
            mitelf = new Cliente();
            Telefono tl = new Telefono();
            mitelf.setCedula(resultado.getString(1));
            tl.setId(resultado.getInt(2));
            mitelf.setMifono(tl);
            mitelf.setNombres(resultado.getString(3));
        }
        db.cerrarConexion();
        return mitelf;
    }

    public Cliente buscarCedula(String cedula) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from cliente where cedula='" + cedula + "'";

        ResultSet resultado = db.seleccion(query);
        Cliente cliente = null;
        if (resultado != null && resultado.next() != false) {
            //resultado.next();
            cliente = new Cliente();
            Telefono telefono = new Telefono();
            cliente.setCedula(resultado.getString(1));
            telefono.setId(resultado.getInt(2));
            cliente.setMifono(telefono);
            cliente.setNombres(resultado.getString(3));
        }
        db.cerrarConexion();
        return cliente;
    }
}
