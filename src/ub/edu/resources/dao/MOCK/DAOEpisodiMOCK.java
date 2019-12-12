package ub.edu.resources.dao.MOCK;


import ub.edu.model.Episodi;
import ub.edu.model.Temporada;
import ub.edu.resources.dao.DAOEpisodi;
import ub.edu.resources.dao.DAOTemporada;

import java.util.*;

public class DAOEpisodiMOCK implements DAOEpisodi {
    private Map<String, Episodi> idEpisodi = new HashMap<>();

    public DAOEpisodiMOCK() {
        // TODO: Posar algunes sèries de la taula hash idToSerie

        Episodi primera = new Episodi("bbad@1","Piloto",55);
        idEpisodi.put(primera.getIdentificador(),primera);
        Episodi segona = new Episodi("bbad@1","Cat's in the bag",55);
        idEpisodi.put(segona.getIdentificador(),segona);
        Episodi e1 = new Episodi("pblinders@1","ep1",55);
        idEpisodi.put(e1.getIdentificador(),e1);
        Episodi e2 = new Episodi("mrobot@1","ep1",55);
        idEpisodi.put(e2.getIdentificador(),e2);
    }


    @Override
    public List<Episodi> getAll() {
        return new ArrayList<>(idEpisodi.values());
    }

    @Override
    public Optional<Episodi> getById(String id) {
        return Optional.ofNullable(idEpisodi.get(id));
    }

    @Override
    public boolean add(final Episodi episodi) {

        if (getById(episodi.getIdentificador()).isPresent()) {
            return false;
        }
        idEpisodi.put(episodi.getIdentificador(), episodi);
        return true;
    }

    @Override
    public boolean update(final Episodi episodi, String[] params) {
        return false;
    }

    @Override
    public boolean delete(final Episodi episodi) {
        return idEpisodi.remove(episodi.getIdentificador()) != null;
    }
}
