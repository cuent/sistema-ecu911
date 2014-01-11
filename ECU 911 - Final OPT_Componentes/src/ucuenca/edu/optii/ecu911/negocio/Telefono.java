/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucuenca.edu.optii.ecu911.dao.TelefonoDB;
import ucuenca.edu.optii.ecu911.negocio.excepciones.TelefonoVerificacionException;

/**
 *
 * @author May
 */
public class Telefono {

    int id;
    String tipo;
    String numero;
    Intz_EstadosTelefono miestado;
     public Telefono() {
        miestado = new E_Disponible();
    }
    
    public void EstablecerEstado(Intz_EstadosTelefono es) {
    }

    public void SuspenderTelefono() {
        miestado = new E_suspendido();
    }

    public void OcuparTelefono() {
        miestado = new E_Ocupado();
    }

    public void EsperarTelefono() {
        miestado = new E_Espera();
    }

    public void LiberarTelefono() {
        miestado = new E_Disponible();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public boolean grabar()throws TelefonoVerificacionException, SQLException{
         TelefonoDB aspfDB = new TelefonoDB();
         if(aspfDB.grabar(this)){
             return true;
         }else{
                throw new TelefonoVerificacionException("Error al Grabar la entidad Telefono");         
         }
      
    }
    
    public boolean buscarNumeroSegunIde() throws TelefonoVerificacionException{
        try {
            Telefono aux;
            TelefonoDB aspectoDB = new TelefonoDB();
            aux = aspectoDB.buscar(this.id);
            
            if(aux!=null){
             setId(aux.getId());
             setTipo(aux.getTipo()); 
             setNumero(aux.getNumero());
             return true;
            }else{       
                throw new TelefonoVerificacionException("No se ha encontrado los datos de telefono");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return false;
    }
    
    public boolean buscarNumero()throws TelefonoVerificacionException{
        try {
            Telefono aux;
            TelefonoDB aspectoDB = new TelefonoDB();
            aux = aspectoDB.buscarNumero(this.numero);
            
            if(aux!=null){
             setId(aux.getId());
             setTipo(aux.getTipo()); 
             setNumero(aux.getNumero());
             return true;
            }else{       
                   throw new TelefonoVerificacionException("No se ha encontrado los datos de telefono");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return false;
    }
}