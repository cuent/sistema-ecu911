package ucuenca.edu.optii.ecu911.negocio;

/**
 *
 * @author cuent
 */
public class LlamarEntidad implements Visitor {

    @Override
    public String visitar(EntidadBomberos bomberos) {
        return bomberos.getNombre();
    }

    @Override
    public String visitar(EntidadCNT cnt) {
        return cnt.getNombre();
    }

    @Override
    public String visitar(EntidadFuerzasArmadas fuerzasArmadas) {
        return fuerzasArmadas.getNombre();
    }

    @Override
    public String visitar(EntidadPolicia policia) {
        return policia.getNombre();
    }

    @Override
    public String visitar(EntidadGestionRiesgos gestionRiesgos) {
        return gestionRiesgos.getNombre();
    }

    @Override
    public String visitar(EntidadCruzRoja cruzRoja) {
        return cruzRoja.getNombre();
    }
}