package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Temporada {
    private HashMap<String,Episodi> episodis;
    private int  ntemporada;
    private String idSerie;

    public Temporada(int ntemporada,String idSerie){
        this.idSerie = idSerie;
        this.ntemporada = ntemporada;
        episodis = new HashMap<String,Episodi>();
    }


    public String getIdentificador(){
        return idSerie +"@"+ntemporada;
    }


    public String getIdSerie(){return idSerie;}

    public int getNtemporada() {
        return ntemporada;
    }



    public Episodi findEpisodi(String episodi){
        return episodis.get(episodi);
    }

    public void addEpisodi(Episodi episodi) {
        episodis.put(episodi.getNom(),episodi);
    }


    public int getDuradaEpisodi(String episodi) {
        return findEpisodi(episodi).getDuradaEpisodi();
    }

    public Collection<Episodi> getAllEpisodis() {
        return episodis.values();
    }

    public String[] getEpisodis() {
        String[] returnValue = new String[episodis.size()];
        for(int i = 0; i < episodis.size(); i++){
            returnValue[i] = episodis.get(i).getNom();
        }
        return returnValue;
    }
}
