/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucuenca.edu.optii.ecu911.dao.ClienteDB;
import ucuenca.edu.optii.ecu911.dao.EntidadDB;
import ucuenca.edu.optii.ecu911.dao.Entidad_TipoIncDB;
import ucuenca.edu.optii.ecu911.dao.OperadorEcuDB;
import ucuenca.edu.optii.ecu911.dao.PermisoDB;
import ucuenca.edu.optii.ecu911.dao.RolDB;
import ucuenca.edu.optii.ecu911.dao.TelefonoDB;
import ucuenca.edu.optii.ecu911.dao.TipoIncidenteDB;

/**
 *
 * @author May
 */
public class VectoresObj {
     private ArrayList permisos=new ArrayList();
     private ArrayList clientes=new ArrayList();
     private ArrayList roles=new ArrayList();
     private ArrayList opEcus=new ArrayList();
     private ArrayList opEntidades=new ArrayList();
     private ArrayList centros=new ArrayList();
     private ArrayList entidades=new ArrayList();
     private ArrayList servicios=new ArrayList();
     private ArrayList telefonos=new ArrayList();
     private ArrayList incidentes=new ArrayList();
     private ArrayList tiposInc=new ArrayList();
     private ArrayList entidades_tiposInc=new ArrayList();
     private ArrayList telfsDisponibles=new ArrayList();
     
     
    public ArrayList getTelfsDisponibles() {
        return telfsDisponibles;
    }

    public void setTelfsDisponibles(ArrayList telfsDisponibles) {
        this.telfsDisponibles = telfsDisponibles;
    }
 
    public ArrayList getEntidades_tiposInc() {
        return entidades_tiposInc;
    }

    public void setEntidades_tiposInc(ArrayList entidades_tiposInc) {
        this.entidades_tiposInc = entidades_tiposInc;
    }
      

    public ArrayList getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(ArrayList incidentes) {
        this.incidentes = incidentes;
    }

    public ArrayList getTiposInc() {
        return tiposInc;
    }

    public void setTiposInc(ArrayList tiposInc) {
        this.tiposInc = tiposInc;
    }

     
    public ArrayList getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList getPermisos() {
        return permisos;
    }

    public void setPermisos(ArrayList permisos) {
        this.permisos = permisos;
    }

    public ArrayList getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }

    public ArrayList getRoles() {
        return roles;
    }

    public void setRoles(ArrayList roles) {
        this.roles = roles;
    }

    public ArrayList getOpEcus() {
        return opEcus;
    }

    public void setOpEcus(ArrayList opEcus) {
        this.opEcus = opEcus;
    }

    public ArrayList getOpEntidades() {
        return opEntidades;
    }

    public void setOpEntidades(ArrayList opEntidades) {
        this.opEntidades = opEntidades;
    }

    public ArrayList getCentros() {
        return centros;
    }

    public void setCentros(ArrayList centros) {
        this.centros = centros;
    }

    public ArrayList getEntidades() {
        return entidades;
    }

    public void setEntidades(ArrayList entidades) {
        this.entidades = entidades;
    }

    public ArrayList getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList servicios) {
        this.servicios = servicios;
    }
     public void listarTiposIncidentesSegunEntidades(int entid) {
        try {
            Entidad_TipoIncDB aspPerm = new Entidad_TipoIncDB();
            setEntidades_tiposInc(aspPerm.buscar(entid));
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
 
    public void listarPermisos() {
        try {
            PermisoDB aspPerm = new PermisoDB();
            setPermisos(aspPerm.listar());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
      public void listarRoles() {
        try {
            RolDB aspPerm = new RolDB();
            setRoles(aspPerm.listar());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
      
      public void listarTelefonos() {
        try {
            TelefonoDB aspPerm = new TelefonoDB();
            setTelefonos(aspPerm.listar());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
      
       public void listarClientes() {
        try {
            ClienteDB aspPerm = new ClienteDB();
            setClientes(aspPerm.listar());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public void listarTipoIncidentes() {
        try {
            TipoIncidenteDB aspPerm = new TipoIncidenteDB();
            setTiposInc(aspPerm.listar());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }  
    
    public void listarOperadoresEcu() {
        try {
            OperadorEcuDB aspPerm = new OperadorEcuDB();
            setOpEcus(aspPerm.listar());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
     public void listarEntidades() {
        try {
            EntidadDB aspPerm = new EntidadDB();
            setEntidades(aspPerm.listar());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
     public void listarTelefonosDisponibles() {
        try {
            TelefonoDB aspPerm = new TelefonoDB();
            setTelfsDisponibles(aspPerm.listarDisponibles());
        } catch (SQLException ex) {
            Logger.getLogger(VectoresObj.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
     
}
