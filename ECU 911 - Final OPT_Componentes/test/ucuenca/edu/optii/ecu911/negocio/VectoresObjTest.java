package ucuenca.edu.optii.ecu911.negocio;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
/**
 *
 * @author May
 */
public class VectoresObjTest {
    /**
     * Test of getEntidadesDisponibles method, of class VectoresObj.
     */
    @Test
    public void testGetEntidadesDisponibles() {
        System.out.println("getEntidadesDisponibles");
        VectoresObj instance = new VectoresObj();
        instance.setEntidades(null);
        instance.setEntidadesDisponibles(null);
        ArrayList result = instance.getEntidadesDisponibles();
        assertEquals(null, result);  
    }

    /**
     * Test of setEntidadesDisponibles method, of class VectoresObj.
     */
    @Test
    public void testSetEntidadesDisponibles() {
        System.out.println("setEntidadesDisponibles");
        ArrayList entidadesDisponibles = new ArrayList();
        VectoresObj instance = new VectoresObj();
        instance.setEntidadesDisponibles(entidadesDisponibles);
        assertEquals(instance.getEntidadesDisponibles(), entidadesDisponibles);
    }

    /**
     * Test of getTelfsDisponibles method, of class VectoresObj.
     */
    @Test
    public void testGetTelfsDisponibles() {
        System.out.println("getTelfsDisponibles");
        VectoresObj instance = new VectoresObj();
        instance.setTelfsDisponibles(null);
        ArrayList expResult = null;
        ArrayList result = instance.getTelfsDisponibles();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelfsDisponibles method, of class VectoresObj.
     */
    @Test
    public void testSetTelfsDisponibles() {
        System.out.println("setTelfsDisponibles");
        ArrayList telfsDisponibles = null;
        VectoresObj instance = new VectoresObj();
        instance.setTelfsDisponibles(telfsDisponibles);
        assertEquals(instance.getTelfsDisponibles(), null);
    }

    /**
     * Test of getEntidades_tiposInc method, of class VectoresObj.
     */
    @Test
    public void testGetEntidades_tiposInc() {
        System.out.println("getEntidades_tiposInc");
        VectoresObj instance = new VectoresObj();
        instance.setEntidades_tiposInc(null);
        ArrayList expResult = null;
        ArrayList result = instance.getEntidades_tiposInc();
        assertEquals(expResult, result);     
    }

    /**
     * Test of setEntidades_tiposInc method, of class VectoresObj.
     */
    @Test
    public void testSetEntidades_tiposInc() {
        System.out.println("setEntidades_tiposInc");
        ArrayList entidades_tiposInc = null;
        VectoresObj instance = new VectoresObj();
        instance.setEntidades_tiposInc(entidades_tiposInc);
        assertEquals(instance.getEntidades_tiposInc(), null);
    }

    /**
     * Test of getIncidentes method, of class VectoresObj.
     */
    @Test
    public void testGetIncidentes() {
        System.out.println("getIncidentes");
        VectoresObj instance = new VectoresObj();
        ArrayList expResult = null ;
        instance.setIncidentes(null);
        ArrayList result = instance.getIncidentes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIncidentes method, of class VectoresObj.
     */
    @Test
    public void testSetIncidentes() {
        System.out.println("setIncidentes");
        ArrayList incidentes = null;
        VectoresObj instance = new VectoresObj();
        instance.setIncidentes(incidentes);
        assertEquals(incidentes, instance.getIncidentes());  
    }

    /**
     * Test of getTiposInc method, of class VectoresObj.
     */
    @Test
    public void testGetTiposInc() {
        System.out.println("getTiposInc");
        VectoresObj instance = new VectoresObj();
        ArrayList expResult = null;
        instance.setTiposInc(null);
        ArrayList result = instance.getTiposInc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTiposInc method, of class VectoresObj.
     */
    @Test
    public void testSetTiposInc() {
        System.out.println("setTiposInc");
        ArrayList tiposInc = null;
        VectoresObj instance = new VectoresObj();
        instance.setTiposInc(tiposInc);
        assertEquals(tiposInc, instance.getTiposInc());
       
    }

    /**
     * Test of getTelefonos method, of class VectoresObj.
     */
    @Test
    public void testGetTelefonos() {
        System.out.println("getTelefonos");
        VectoresObj instance = new VectoresObj();
        instance.setTelefonos(null);
        ArrayList expResult = null;
        ArrayList result = instance.getTelefonos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelefonos method, of class VectoresObj.
     */
    @Test
    public void testSetTelefonos() {
        System.out.println("setTelefonos");
        ArrayList telefonos = null;
        VectoresObj instance = new VectoresObj();
        instance.setTelefonos(telefonos);
        assertEquals(instance.getTelefonos(), telefonos);
    }

    /**
     * Test of getPermisos method, of class VectoresObj.
     */
    @Test
    public void testGetPermisos() {
        System.out.println("getPermisos");
        VectoresObj instance = new VectoresObj();
        instance.setPermisos(null);
        ArrayList expResult = null;
        ArrayList result = instance.getPermisos();
        assertEquals(expResult, result);     
    }

    /**
     * Test of setPermisos method, of class VectoresObj.
     */
    @Test
    public void testSetPermisos() {
        System.out.println("setPermisos");
        ArrayList permisos = null;
        VectoresObj instance = new VectoresObj();
        instance.setPermisos(permisos);
        assertEquals(instance.getPermisos(), permisos);  
    }

    /**
     * Test of getClientes method, of class VectoresObj.
     */
    @Test
    public void testGetClientes() {
        System.out.println("getClientes");
        VectoresObj instance = new VectoresObj();
        instance.setClientes(null);
        ArrayList expResult = null;
        ArrayList result = instance.getClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClientes method, of class VectoresObj.
     */
    @Test
    public void testSetClientes() {
        System.out.println("setClientes");
        ArrayList clientes = null;
        VectoresObj instance = new VectoresObj();
        instance.setClientes(clientes);
        assertEquals(clientes, instance.getClientes());
    }

    /**
     * Test of getRoles method, of class VectoresObj.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        VectoresObj instance = new VectoresObj();
        instance.setRoles(null);
        ArrayList expResult = null;
        ArrayList result = instance.getRoles();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoles method, of class VectoresObj.
     */
    @Test
    public void testSetRoles() {
        System.out.println("setRoles");
        ArrayList roles = null;
        VectoresObj instance = new VectoresObj();
        instance.setRoles(roles);
        assertEquals(roles, instance.getRoles());
    }

    /**
     * Test of getOpEcus method, of class VectoresObj.
     */
    @Test
    public void testGetOpEcus() {
        System.out.println("getOpEcus");
        VectoresObj instance = new VectoresObj();
        instance.setOpEcus(null);
        ArrayList expResult = null;
        ArrayList result = instance.getOpEcus();
        assertEquals(expResult, result);       
    }

    /**
     * Test of setOpEcus method, of class VectoresObj.
     */
    @Test
    public void testSetOpEcus() {
        System.out.println("setOpEcus");
        ArrayList opEcus = null;
        VectoresObj instance = new VectoresObj();
        instance.setOpEcus(opEcus);
        assertEquals(opEcus, instance.getOpEcus());
    }

    /**
     * Test of getOpEntidades method, of class VectoresObj.
     */
    @Test
    public void testGetOpEntidades() {
        System.out.println("getOpEntidades");
        VectoresObj instance = new VectoresObj();
        instance.setOpEntidades(null);
        ArrayList expResult = null;
        ArrayList result = instance.getOpEntidades();
        assertEquals(expResult, result);     
    }

    /**
     * Test of setOpEntidades method, of class VectoresObj.
     */
    @Test
    public void testSetOpEntidades() {
        System.out.println("setOpEntidades");
        ArrayList opEntidades = null;
        VectoresObj instance = new VectoresObj();
        instance.setOpEntidades(opEntidades);
        assertEquals(instance.getOpEntidades(), opEntidades);
    }

    /**
     * Test of getCentros method, of class VectoresObj.
     */
    @Test
    public void testGetCentros() {
        System.out.println("getCentros");
        VectoresObj instance = new VectoresObj();
        instance.setCentros(null);
        ArrayList expResult = null;
        ArrayList result = instance.getCentros();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCentros method, of class VectoresObj.
     */
    @Test
    public void testSetCentros() {
        System.out.println("setCentros");
        ArrayList centros = null;
        VectoresObj instance = new VectoresObj();
        instance.setCentros(centros);
        assertEquals(centros, instance.getCentros());
    }

    /**
     * Test of getEntidades method, of class VectoresObj.
     */
    @Test
    public void testGetEntidades() {
        System.out.println("getEntidades");
        VectoresObj instance = new VectoresObj();
        instance.setEntidades(null);
        ArrayList expResult = null;
        ArrayList result = instance.getEntidades();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEntidades method, of class VectoresObj.
     */
    @Test
    public void testSetEntidades() {
        System.out.println("setEntidades");
        ArrayList entidades = null;
        VectoresObj instance = new VectoresObj();
        instance.setEntidades(entidades);
        assertEquals(entidades, instance.getEntidades());
    }

    /**
     * Test of getServicios method, of class VectoresObj.
     */
    @Test
    public void testGetServicios() {
        System.out.println("getServicios");
        VectoresObj instance = new VectoresObj();
        instance.setServicios(null);
        ArrayList expResult = null;
        ArrayList result = instance.getServicios();
        assertEquals(expResult, result);
    }

    /**
     * Test of setServicios method, of class VectoresObj.
     */
    @Test
    public void testSetServicios() {
        System.out.println("setServicios");
        ArrayList servicios = null;
        VectoresObj instance = new VectoresObj();
        instance.setServicios(servicios);
        assertEquals(servicios, instance.getServicios());
    }

    /**
     * Test of getMisregistros method, of class VectoresObj.
     */
    @Test
    public void testGetMisregistros() {
        System.out.println("getMisregistros");
        VectoresObj instance = new VectoresObj();
        instance.setMisregistros(null);
        ArrayList expResult = null;
        ArrayList result = instance.getMisregistros();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMisregistros method, of class VectoresObj.
     */
    @Test
    public void testSetMisregistros() {
        System.out.println("setMisregistros");
        ArrayList misregistros = null;
        VectoresObj instance = new VectoresObj();
        instance.setMisregistros(misregistros);
        assertEquals(instance.getMisregistros(), misregistros);
    }

    /**
     * Test of getSesiones method, of class VectoresObj.
     */
    @Test
    public void testGetSesiones() {
        System.out.println("getSesiones");
        VectoresObj instance = new VectoresObj();
        instance.setSesiones(null);
        ArrayList expResult = null;
        ArrayList result = instance.getSesiones();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSesiones method, of class VectoresObj.
     */
    @Test
    public void testSetSesiones() {
        System.out.println("setSesiones");
        ArrayList sesiones = null;
        VectoresObj instance = new VectoresObj();    
        instance.setSesiones(sesiones);
       assertEquals(null, sesiones);
    }

    /**
     * Test of listarTiposIncidentesSegunEntidades method, of class VectoresObj.
     */
    @Test
    public void testListarTiposIncidentesSegunEntidades() {
        System.out.println("listarTiposIncidentesSegunEntidades");
        int entid = 0;
        ArrayList enti=new ArrayList();
        VectoresObj instance = new VectoresObj();
        instance.listarTiposIncidentesSegunEntidades(entid);
        assertEquals(enti, instance.getEntidades_tiposInc());
    }

    /**
     * Test of listarRegistrosLlamadas method, of class VectoresObj.
     */
    @Ignore
    @Test
    public void testListarRegistrosLlamadas() {
        System.out.println("listarRegistrosLlamadas");
        VectoresObj instance = new VectoresObj();
        instance.listarRegistrosLlamadas();
    }

    /**
     * Test of listarPermisos method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarPermisos() {
        System.out.println("listarPermisos");
        VectoresObj instance = new VectoresObj();
        instance.listarPermisos();
    }

    /**
     * Test of listarRoles method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarRoles() {
        System.out.println("listarRoles");
        VectoresObj instance = new VectoresObj();
        instance.listarRoles();
    }

    /**
     * Test of listarSesiones method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarSesiones() {
        System.out.println("listarSesiones");
        VectoresObj instance = new VectoresObj();
        instance.listarSesiones(); 
    }

    /**
     * Test of listarTelefonos method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarTelefonos() {
        System.out.println("listarTelefonos");
        VectoresObj instance = new VectoresObj();
        instance.listarTelefonos();
    }

    /**
     * Test of listarClientes method, of class VectoresObj.
     */
    @Test(timeout=200)
    public void testListarClientes() {
        System.out.println("listarClientes");
        VectoresObj instance = new VectoresObj();
        instance.listarClientes();  
    }

    /**
     * Test of listarTipoIncidentes method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarTipoIncidentes() {
        System.out.println("listarTipoIncidentes");
        VectoresObj instance = new VectoresObj();
        instance.listarTipoIncidentes();
    }

    /**
     * Test of listarOperadoresEntidades method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarOperadoresEntidades() {
        System.out.println("listarOperadoresEntidades");
        VectoresObj instance = new VectoresObj();
        instance.listarOperadoresEntidades();  
    }

    /**
     * Test of listarOperadoresEcu method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarOperadoresEcu() {
        System.out.println("listarOperadoresEcu");
        VectoresObj instance = new VectoresObj();
        instance.listarOperadoresEcu();
    }

    /**
     * Test of listarEntidades method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarEntidades() {
        System.out.println("listarEntidades");
        VectoresObj instance = new VectoresObj();
        instance.listarEntidades();     
    }

    /**
     * Test of listarEntidadesDisponibles method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarEntidadesDisponibles() {
        System.out.println("listarEntidadesDisponibles");
        VectoresObj instance = new VectoresObj();
        instance.listarEntidadesDisponibles();
    }

    /**
     * Test of listarTelefonosDisponibles method, of class VectoresObj.
     */
    @Test(timeout=300)
    public void testListarTelefonosDisponibles() {
        System.out.println("listarTelefonosDisponibles");
        VectoresObj instance = new VectoresObj();
        instance.listarTelefonosDisponibles();  
    }
}