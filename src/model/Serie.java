package model;

import model.DetallsSerie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Serie {
    private String idSerie;
    private int ntemporades;
    private HashMap<Integer, Temporada> temporades;
    private DetallsSerie detallsSerie;


    public Serie(String idSerie, String titol) {
        detallsSerie = new DetallsSerie();
        this.idSerie = idSerie;
        this.setTitol(titol);
        temporades = new HashMap<Integer, Temporada>();
    }


    public String getIdSerie() {
        return idSerie;
    }


    public String getTitol() {
        return this.detallsSerie.getTitol();
    }

    public void setTitol(String titol) {
        this.detallsSerie.setTitol(titol);
    }

    public void setDescripcio(String descripcio){detallsSerie.setDescripcio(descripcio);}


    public void setProductoraData(String nom,String id,String anyCreacio){
        detallsSerie.setProductoraData(nom, id, anyCreacio);
    }
    public void addDirectorData(String id,String nomReal, String nacionalitat){
        detallsSerie.addDirectorData(id, nomReal, nacionalitat);
    }
    public void addActorData(String id,String nomReal, String nacionalitat){
        detallsSerie.addActorData(id, nomReal, nacionalitat);
    }

    public DetallsSerie getDetallsSerie(){
        return detallsSerie;
    }



    public Temporada findTemporada(int num) {
        return temporades.get(num);
    }

    public void addTemporadaToSerie(Temporada temporada){
        this.temporades.put(temporada.getNtemporada(),temporada);
    }

    public void addEpisodiToTemporada(String temporada,Episodi episodi) {
        findTemporada(Integer.parseInt(temporada)).addEpisodi(episodi);
    }


    public String mostrarDetallsSerie(){
        return getDetallsSerie().toString();
    }

    public int getDuradaEpisodi(int temporada, String episodi) {
        return findTemporada(temporada).getDuradaEpisodi(episodi);
    }

    public List<Episodi> getAllEpisodis() {
        ArrayList<Episodi> episodis = new ArrayList<>();
        for(Temporada temporada:temporades.values()){
            episodis.addAll(temporada.getAllEpisodis());
        }
        return episodis;

    }

    public String[] getTemporades() {

        return (String[])temporades.values().toArray();


    }
}


