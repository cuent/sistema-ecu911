package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class ClienteTest {
     String resDireccion = "Los olivos";
  
    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = new Cliente();
        instance.direccion="Los olivos";      
        String result = instance.getDireccion();
        assertEquals(resDireccion, result);
       }

    /**
     * Test of setDireccion method, of class Cliente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "calle de la quena";
        Cliente instance = new Cliente();
        instance.setDireccion(direccion);
        assertEquals(direccion, instance.getDireccion());       
    }

    /**
     * Test of getMifono method, of class Cliente.
     */
    @Test
    public void testGetMifono() {
        System.out.println("getMifono");
        Cliente instance = new Cliente();
        Telefono expResult = null;
        Telefono result = instance.getMifono();
        assertEquals(expResult, result);   
    }

    /**
     * Test of setMifono method, of class Cliente.
     */
    @Test
    public void testSetMifono() {
        System.out.println("setMifono");
        Telefono mifono = new Telefono();
        mifono.setId(5);
        Cliente instance = new Cliente();
        instance.setMifono(mifono);
        assertEquals(mifono, instance.getMifono());
    }
  
    /**
     * Test of grabar method, of class Cliente.
     */
    /*
    @Test
    public void testGrabar() {
        System.out.println("grabar");
        Cliente instance = new Cliente();
        instance.setCedula("010208");
        instance.setNombres("cliente nuevo");
        instance.setDireccion("mi direccion");
          Telefono fono = new Telefono();
          fono.setId(2);
        instance.setMifono(fono);
        boolean result = instance.grabar();
        assertEquals(false, result);    
    }*/

    /**
     * Test of buscar method, of class Cliente.
     */
   /* @Test
    public void testBuscar() {
        System.out.println("buscar");
        Cliente instance = new Cliente();
        Telefono fono=new Telefono();
        fono.setId(2);
        instance.setMifono(fono);
        boolean result = instance.buscar();
        assertTrue("esperando telefono true", result);
    }*/

    /**
     * Test of buscarCedula method, of class Cliente.
     */
   /* @Test
    public void testBuscarCedula() {
        System.out.println("buscarCedula");
        Cliente instance = new Cliente();
        instance.setCedula("010203");
        boolean result = instance.buscarCedula();
        assertTrue("esperando cedula true", result);   
    }*/
}