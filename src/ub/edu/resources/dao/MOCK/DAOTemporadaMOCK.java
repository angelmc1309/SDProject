package resources.dao.MOCK;


import ub.edu.model.Temporada;
import ub.edu.resources.dao.DAOTemporada;

import java.util.*;

public class DAOTemporadaMOCK implements DAOTemporada {
    private Map<String, Temporada> idTemporada = new HashMap<>();

    public DAOTemporadaMOCK() {
        // TODO: Posar algunes sèries de la taula hash idToSerie

        Temporada primera = new Temporada(1,"bbad");
        idTemporada.put(primera.getIdentificador(),primera);
        Temporada segona = new Temporada(2,"bbad");
        idTemporada.put(segona.getIdentificador(),segona);
        Temporada t3 = new Temporada(1,"pblinders");
        idTemporada.put(t3.getIdentificador(),t3);
        Temporada t4 = new Temporada(1,"mrobot");
        idTemporada.put(t4.getIdentificador(),t4);
    }


    @Override
    public List<Temporada> getAll() {
        return new ArrayList<>(idTemporada.values());
    }

    @Override
    public Optional<Temporada> getById(String id) {
        return Optional.ofNullable(idTemporada.get(id));
    }

    @Override
    public boolean add(final Temporada temporada) {

        if (getById(temporada.getIdentificador()).isPresent()) {
            return false;
        }
        idTemporada.put(temporada.getIdentificador(), temporada);
        return true;
    }

    @Override
    public boolean update(final Temporada temporada, String[] params) {

        return false;
    }

    @Override
    public boolean delete(final Temporada temporada) {
        return idTemporada.remove(temporada.getIdentificador()) != null;
    }
}
