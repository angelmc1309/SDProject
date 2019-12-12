package ub.edu.resources.dao.MOCK;

import ub.edu.model.Valoracions;
import ub.edu.model.ValoracionsEstrelles;
import ub.edu.model.ValoracionsThumb;
import ub.edu.model.Visualitzacio;
import ub.edu.resources.dao.DAOVisualitzacio;

import java.util.*;

public class DAOVisualitzacioMOCK implements DAOVisualitzacio{
    private Map<String, Visualitzacio> visualitzacions = new HashMap<>();

    public DAOVisualitzacioMOCK() {
        Visualitzacio v1 = new Visualitzacio("ajaleo","ajaleoUser1","bbad@1@Piloto",
                55);
        v1.startVisualitzacio();
        v1.endVisualitzacio(0);
        visualitzacions.put(v1.getIdentificador(),v1);
        Visualitzacio v2 = new Visualitzacio("ajaleo","ajaleoUser2","bbad@1@Piloto",
                55);
        v2.startVisualitzacio();
        v2.endVisualitzacio(0);
        visualitzacions.put(v2.getIdentificador(),v2);
        Visualitzacio v3 = new Visualitzacio("ajaleo","ajaleoUser3","mrobot@1@ep1",
                55);
        v3.startVisualitzacio();
        v3.endVisualitzacio(5);
        visualitzacions.put(v3.getIdentificador(),v3);
        Visualitzacio v4 = new Visualitzacio("ajaleo","ajaleoUser2","bbad@1@Cat's in the bag",
                55);
        v4.startVisualitzacio();
        v4.endVisualitzacio(0);
        visualitzacions.put(v4.getIdentificador(),v4);
        Visualitzacio v5 = new Visualitzacio("lmento","lmentoUser","pblinders@1@ep1",
                55);
        v5.startVisualitzacio();
        v5.endVisualitzacio(30);
        visualitzacions.put(v5.getIdentificador(),v5);


    }


    @Override
    public List<Visualitzacio> getAll() {
        return new ArrayList<>(visualitzacions.values());
    }

    @Override
    public Optional<Visualitzacio> getById(String id) {
        return Optional.ofNullable(visualitzacions.get(id));
    }

    @Override
    public boolean add(final Visualitzacio visualitzacio) {

        if (visualitzacions.containsKey(visualitzacio.getIdentificador())) {
            return false;
        }
        visualitzacions.put(visualitzacio.getIdentificador(), visualitzacio);
        return true;
    }

    @Override
    public boolean update(final Visualitzacio visualitzacio, String[] params) {

        return false;
    }

    @Override
    public boolean delete(final Visualitzacio visualitzacio) {
        return visualitzacions.remove(visualitzacio.getIdentificador()) != null;
    }

    @Override
    public boolean alreadyContainsVisualitzacio(String idVisualitzacio) {
        return visualitzacions.containsKey(idVisualitzacio);
    }
}
