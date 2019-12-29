package model;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import sun.security.jca.GetInstance;

import java.util.List;

public class BibliotecaSeries {

    private List<Serie> biblioteca;

    public BibliotecaSeries(List<Serie> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Serie find(String idSerie) {

        for (Serie serie: biblioteca) {
            if (serie.getIdSerie().equals(idSerie)) return serie;
        }
        return null;
    }

    public void updateTemporades(List<Temporada> l){
        for (Temporada temporada : l){
            find(temporada.getIdSerie()).addTemporadaToSerie(temporada);
        }
    }

    public void updateEpisodis(List<Episodi> l) {
        for(Episodi episodi: l ){

            find(episodi.getIdSerie()).addEpisodiToTemporada(
                    episodi.getIdTemporada(),episodi
            );
        }
    }


    public String mostrarDetallsSerie(String idSerie) {
        if (find(idSerie) != null){
            return find(idSerie).mostrarDetallsSerie();
        }
        else{
            return "Sèrie no vàlida";
        }
    }

    public int getDuradaEpisodi(String serie, int temporada, String episodi) {
        return find(serie).getDuradaEpisodi(temporada,episodi);
    }

    public List<Serie> getAllSeries() {
        return biblioteca;
    }

    public List<Episodi> getAllEpisodis(Serie s) {
        return find(s.getIdSerie()).getAllEpisodis();
    }

    public String llistarCatalegSeries(){
        String auxiliar = "";
        for (Serie serie: biblioteca){
            auxiliar += serie.getTitol() + "\n";
        }
        return auxiliar;
    }

    public String[] getTemporadaSerie(String serie) {
        return find(serie).getTemporades();
    }
}
