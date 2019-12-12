package ub.edu.resources.dao.MOCK;

import ub.edu.model.MyList;
import ub.edu.resources.dao.DAOFavorits;

import java.util.*;

public class DAOFavoritsMOCK implements DAOFavorits {
    private Map<String, MyList> favoritsHashMap = new HashMap<>();

    public DAOFavoritsMOCK() {
        MyList f1 = new MyList("ajaleo@ajaleoUser1");
        f1.addSerie("bbad");
        favoritsHashMap.put(f1.getIdentificador(),f1);
        MyList f2 = new MyList("ajaleo@ajaleoUser2");
        f2.addSerie("bbad");
        f2.addSerie("pblinders");
        favoritsHashMap.put(f2.getIdentificador(),f2);



    }


    @Override
    public List<MyList> getAll() {
        return new ArrayList<>(favoritsHashMap.values());
    }

    @Override
    public Optional<MyList> getById(String id) {
        return Optional.ofNullable(favoritsHashMap.get(id));
    }

    @Override
    public boolean add(final MyList myList) {
        if (!favoritsHashMap.containsKey(myList.getIdentificador())){
            favoritsHashMap.put(myList.getIdentificador(), myList);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean update(final MyList myList, String[] params) {
        return false;

    }

    @Override
    public boolean delete(final MyList myList) {
        return favoritsHashMap.remove(myList.getIdentificador()) != null;
    }
}
