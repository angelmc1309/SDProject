package ub.edu.model;

import java.util.ArrayList;
import java.util.List;


public class MyList {
    String idClientUser;
    List<String> favorits;
    public MyList(String idClientUser){
        this.idClientUser = idClientUser;
        favorits = new ArrayList<String>();
    }

    public String getIdentificador() {
        return idClientUser;
    }
    public void addSerie(String serie){
        favorits.add(serie);
    }

    public boolean contains(String idSerie) {
        return favorits.contains(idSerie);
    }

    public boolean isEmpty() {
        return favorits.isEmpty();
    }

    public List<String> getFavorits() {
        return favorits;
    }

    public String getClient() {
        return idClientUser.split("@")[0];
    }

    public String getUser() {
        return idClientUser.split("@")[1];
    }
    //
}
