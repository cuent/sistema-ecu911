/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author May
 */
public class CentroEcu_ObservadoTest {
    public CentroEcu_Observado instance = new CentroEcu_Observado();
    List<Intz_EntidadCooperativa_Observador> observadores = new ArrayList<>() ;
   
    EntidadBomberos bomberos=new EntidadBomberos();
    String ciudadResultado= "Quito";
    public CentroEcu_ObservadoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testSetId() {
        System.out.println("metodo set ID");
        int id = 456;
        instance.setId(id);
        assertEquals(id, instance.getId()); 
    }

    @Test
    public void testSetObservadores() {
        System.out.println("setObservadores");
        EntidadCooperativa mientidad=new EntidadBomberos();
        observadores.add(mientidad);
        CentroEcu_Observado.setObservadores(observadores);
       
    }
   @Test
    public void testSetCiudad() {
        System.out.println("setCiudad");
        String ciudad = "Quito";
        instance.setCiudad(ciudad);
        System.out.print("ciudad: "+instance.getCiudad());
        assertEquals(ciudad, instance.getCiudad());
    }
    
    @Test
    public void testGetId() {
        System.out.println("metodo Get ID");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
        String esper=null;
        String result = instance.getCiudad();
       
        assertEquals(esper, result);
       
    }
    @Test
    public void testGetObservadores() {
        System.out.println("metodo get Observadores");
        List expResult = new ArrayList();
        expResult.add(bomberos);
        observadores.add(bomberos);
        CentroEcu_Observado.setObservadores(observadores);
        assertEquals(expResult, CentroEcu_Observado.getObservadores());
     
    }
    @Test
    public void testAgregarEntidadObservadora() {
        System.out.println("agregar Entidad Observadora");
        Intz_EntidadCooperativa_Observador mientidad = null;
        instance.agregarEntidadObservadora(mientidad);
    }

    /**
     * Test of eliminarEntidadObservadora method, of class CentroEcu_Observado.
     */
    @Test
    public void testEliminarEntidadObservadora() {
        System.out.println("eliminarEntidadObservadora");
        Intz_EntidadCooperativa_Observador mientidad = bomberos;
        instance.eliminarEntidadObservadora(mientidad);
    }

    /**
     * Test of notificar method, of class CentroEcu_Observado.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        String expResult="Bomberos en camino...";
        String result = instance.notificar();
        System.out.println(result+""+expResult);
        //assertEquals(expResult.toString(),result.toString());
       
    }
}
