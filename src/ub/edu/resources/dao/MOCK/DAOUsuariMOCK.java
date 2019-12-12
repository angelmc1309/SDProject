package ub.edu.resources.dao.MOCK;

import ub.edu.model.Serie;
import ub.edu.model.Usuari;
import ub.edu.resources.dao.DAOSerie;
import ub.edu.resources.dao.DAOUsuari;

import java.util.*;
//////Problemas muy serios
public class DAOUsuariMOCK implements DAOUsuari{
    private Map<String, Usuari> listUsuaris = new HashMap<>();

    public DAOUsuariMOCK()  {
        listUsuaris.put("ajaleo@ajaleoUser1",new Usuari("ajaleoUser1","ajaleo"));
        listUsuaris.put("ajaleo@ajaleoUser2",new Usuari("ajaleoUser2","ajaleo"));
        listUsuaris.put("ajaleo@ajaleoUser3",new Usuari("ajaleoUser3","ajaleo"));
        listUsuaris.put("ajaleo@ajaleoUser4",new Usuari("ajaleoUser4","ajaleo"));
        listUsuaris.put("ajaleo@ajaleoUser5",new Usuari("ajaleoUser5","ajaleo"));
        listUsuaris.put("ajaleo@ajaleoUser5",new Usuari("ajaleoUser5","ajaleo"));
        listUsuaris.put("lmento@lmentoUser",new Usuari("lmentoUser","lmento"));



    }

    @Override
    public Optional<Usuari> getById(String id) {
        return Optional.ofNullable(listUsuaris.get(id));
    }

    @Override
    public List<Usuari> getAll() {
        return new ArrayList<>(listUsuaris.values());
    }

    @Override
    public boolean add(Usuari usuari) {
        if(listUsuaris.containsKey(usuari.getIdentificador())){
            return false;
        }
        this.listUsuaris.put(usuari.getIdentificador(),usuari);
        return true;
    }

    @Override
    public boolean update(Usuari usuari, String[] params) {
        usuari.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));

        return listUsuaris.replace(usuari.getIdentificador(), usuari) != null;
    }

    @Override
    public boolean delete(Usuari usuari) {
        return listUsuaris.remove(usuari.getIdentificador()) != null;
    }


}
