package ucuenca.edu.optii.ecu911.negocio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author May
 */
public class VisitorTest {
    /**
     * Test of visitar method, of class Visitor.
     */
    @Test
    public void testVisitar_EntidadBomberos() {
        System.out.println("visitar");
        EntidadBomberos bomberos = null;
        Visitor instance = new VisitorImpl();
        String expResult = "visitando bomberos";
        String result = instance.visitar(bomberos);
        assertEquals(expResult, result);
    }

    /**
     * Test of visitar method, of class Visitor.
     */
    @Test
    public void testVisitar_EntidadCNT() {
        System.out.println("visitar");
        EntidadCNT cnt = null;
        Visitor instance = new VisitorImpl();
        String expResult = "visitando cnt";
        String result = instance.visitar(cnt);
        assertEquals(expResult, result);   
    }
    /**
     * Test of visitar method, of class Visitor.
     */
    @Test
    public void testVisitar_EntidadFuerzasArmadas() {
        System.out.println("visitar");
        EntidadFuerzasArmadas fuerzasArmadas = null;
        Visitor instance = new VisitorImpl();
        String expResult = "visitando fuerzas armadas";
        String result = instance.visitar(fuerzasArmadas);
        assertEquals(expResult, result);
    }

    /**
     * Test of visitar method, of class Visitor.
     */
    @Test
    public void testVisitar_EntidadPolicia() {
        System.out.println("visitar");
        EntidadPolicia policia = null;
        Visitor instance = new VisitorImpl();
        String expResult = "visitando policia";
        String result = instance.visitar(policia);
        assertEquals(expResult, result);      
    }

    /**
     * Test of visitar method, of class Visitor.
     */
    @Test
    public void testVisitar_EntidadGestionRiesgos() {
        System.out.println("visitar");
        EntidadGestionRiesgos gestionRiesgos = null;
        Visitor instance = new VisitorImpl();
        String expResult = "visitando gestion de riesgos";
        String result = instance.visitar(gestionRiesgos);
        assertEquals(expResult, result);
    }

    /**
     * Test of visitar method, of class Visitor.
     */
    @Test
    public void testVisitar_EntidadCruzRoja() {
        System.out.println("visitar");
        EntidadCruzRoja cruzRoja = null;
        Visitor instance = new VisitorImpl();
        String expResult = "visitando cruz roja";
        String result = instance.visitar(cruzRoja);
        assertEquals(expResult, result);
    }

    public class VisitorImpl implements Visitor {

        public String visitar(EntidadBomberos bomberos) {
            return "visitando bomberos";
        }

        public String visitar(EntidadCNT cnt) {
            return "visitando cnt";
        }

        public String visitar(EntidadFuerzasArmadas fuerzasArmadas) {
            return "visitando fuerzas armadas";
        }

        public String visitar(EntidadPolicia policia) {
            return "visitando policia";
        }

        public String visitar(EntidadGestionRiesgos gestionRiesgos) {
            return "visitando gestion de riesgos";
        }

        public String visitar(EntidadCruzRoja cruzRoja) {
            return "visitando cruz roja";
        }
    }
}
