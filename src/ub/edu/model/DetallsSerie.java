package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe que detalla la Serie
 * Nota: al constructor no donem cap detall considerem que els afegirem més endevant
 */
public class DetallsSerie {

    private String titol, descripcio;
    private Productora productora;
    private List<Actor> actors;
    private List<Director> directors;

    public DetallsSerie() {
        this.actors = new ArrayList<Actor>();
        this.directors = new ArrayList<Director>();

    }
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setDescripcio(String descripcio){this.descripcio = descripcio;}


    public void setProductoraData(String nom,String id,String anyCreacio){
        this.productora = new Productora(nom, id, anyCreacio);
    }
    public void addDirectorData(String id,String nomReal, String nacionalitat){
        Director d = new Director(id, nomReal, nacionalitat);
        this.directors.add(d);
    }
    public void addActorData(String id,String nomReal, String nacionalitat){
        Actor a = new Actor(id, nomReal, nacionalitat);
        this.actors.add(a);
    }


    @Override
    public String toString() {
        String stringDetalls = "";
        stringDetalls += "Titol: " + this.titol + "\n";
        stringDetalls += "Descripcio: " + this.descripcio + "\n";
        stringDetalls += "Productora: " + this.productora.toString() + "\n";
        stringDetalls += "Directors: ";
        for (Director d : directors) {
            stringDetalls += d.toString() + ",";
        }
        stringDetalls += "\n";
        stringDetalls += "Personatges:" + "\n";
        for (Actor personatge : actors) {
            stringDetalls += personatge.toString() + "\n";
        }
        return stringDetalls;
    }






}
