package resources.dao.MOCK;

import model.Temporada;
import model.Valoracions;
import model.ValoracionsEstrelles;
import model.ValoracionsThumb;
import resources.dao.DAOValoracions;

import java.util.*;

public class DAOValoracionsMOCK implements DAOValoracions
{


    private Map<String, Valoracions> idValoracions = new HashMap<>();

    public DAOValoracionsMOCK() {
        // TODO: Posar algunes sèries de la taula hash idToSerie

        Valoracions valoracions1 = new ValoracionsEstrelles("ajaleo@ajaleoUser1","bbad@1@Piloto");
        valoracions1.setValue(5);//ajaleo ajaleoUser, ajal eoajaleoUser
        idValoracions.put(valoracions1.getIdentificador(),valoracions1);
        Valoracions valoracions2 = new ValoracionsThumb("ajaleo@ajaleoUser3","bbad@1@Piloto");
        valoracions2.setValue(1);
        idValoracions.put(valoracions2.getIdentificador(),valoracions2);
        Valoracions valoracions3 = new ValoracionsThumb("ajaleo@ajaleoUser1",
                "bbad@1@Cat's in the bag");
        valoracions3.setValue(1);
        idValoracions.put(valoracions3.getIdentificador(),valoracions3);
        Valoracions valoracions4 = new ValoracionsEstrelles("ajaleo@ajaleoUser2",
                "bbad@1@Cat's in the bag");
        valoracions4.setValue(4);
        idValoracions.put(valoracions4.getIdentificador(),valoracions4);

    }


    @Override
    public List<Valoracions> getAll() {
        return new ArrayList<>(idValoracions.values());
    }

    @Override
    public Optional<Valoracions> getById(String id) {
        return Optional.ofNullable(idValoracions.get(id));
    }

    @Override
    public boolean add(final Valoracions valoracions) {

        if (idValoracions.containsKey(valoracions.getIdentificador())) {
            return false;
        }
        idValoracions.put(valoracions.getIdentificador(), valoracions);
        return true;
    }

    @Override
    public boolean update(final Valoracions valoracions, String[] params) {
        return false;
    }

    @Override
    public boolean delete(final Valoracions valoracions) {
        return idValoracions.remove(valoracions.getIdentificador()) != null;
    }

}
