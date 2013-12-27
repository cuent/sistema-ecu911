
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.Date;
import ucuenca.edu.optii.ecu911.dao.LoginDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login {
    private int id;
    private String fecha_inicio;
    private String fecha_fin;
    private OperadorEcu usu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public OperadorEcu getUsu() {
        return usu;
    }

    public void setUsu(OperadorEcu usu) {
        this.usu = usu;
    }
    
    
     public void grabar() {
            LoginDB loginDB = new LoginDB();
        try {
            loginDB.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }

    public void buscar() {
        try {
            Login aux;
            LoginDB loginDB = new LoginDB();
            aux = loginDB.buscar(this.id);
            setFecha_inicio(aux.getFecha_inicio());
            setFecha_fin(aux.getFecha_fin());
            setId(aux.getId());      
            setUsu(aux.getUsu());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existe esa id");
        } 
    } 
    
}
