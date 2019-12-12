package controller;

import ub.edu.model.*;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {

    private AbstractFactoryData factory;      // Origen de les dades
    private DataService dataService;         // Connexio amb les dades
    private CarteraClients carteraClients;  //Model
    private BibliotecaSeries bibliotecaSeries;

    public Controller() {
        factory = new FactoryMOCK();
        dataService = new DataService(factory);
        iniCarteraClients();
        iniUsuaris();
        iniSeries();
        iniTemporades();
        iniEpisodis();
        iniValoracions();
        iniFavorits();
        iniVisualitzacions();
    }

    public boolean validateClient(String username, String password) {
        return dataService.getClientByUsuariAndPassword(username, password) != null;
    }

    public boolean iniCarteraClients() {
        List<Client> l = dataService.getAllClients();

        if (l!=null) {
            carteraClients = new CarteraClients(l);
            return true;
        }
        else  return false;
    }

    public boolean iniUsuaris(){
        List<Usuari> l = dataService.getAllUsuaris();
        if (l!=null) {
            carteraClients.updateUsers(l);
            return true;
        }
        else  return false;
    }

    public boolean iniSeries(){
        List<Serie> l = dataService.getAllSeries();
        if (l!=null){
            bibliotecaSeries = new BibliotecaSeries(l);
            return true;
        }
        else return false;
    }

    public boolean iniTemporades(){
        List<Temporada> l = dataService.getAllTemporades();
        if (l!=null){
            bibliotecaSeries.updateTemporades(l);
            return true;
        }
        else return false;
    }

    public boolean iniEpisodis(){
        List<Episodi> l = dataService.getAllEpisodis();
        if (l!=null){
            bibliotecaSeries.updateEpisodis(l);
            return true;
        }
        else return false;
    }

    public boolean iniValoracions(){
        List<Valoracions> l = dataService.getAllValoracions();
        if (l!=null){
            carteraClients.updateValoracions(l);
            return true;
        }
        else return false;
    }
    public boolean iniFavorits(){
        List<MyList> l = dataService.getAllFavorits();
        if (l!=null){
            carteraClients.updateFavorits(l);
            return true;
        }
        else return false;
    }
    public boolean iniVisualitzacions(){
        List<Visualitzacio> l = dataService.getAllVisualitzacions();
        if (l!=null){
            carteraClients.updateVisualitzacions(l);
            return true;
        }
        else return false;

    }



    public String isValidNameClient(String username) {
        Client client = carteraClients.find(username);
        if (client!=null) return "Valid Client";
        else return "Client Unknown";
    }
    public String isValidNameUsuari(String client, String usuari) {
        return carteraClients.isValidNameUsuari(client,usuari);
    }



    public String addClient(String username,String password,String adreça,String nomReal,String dni) {
        Client c = dataService.addClient(username,password,adreça,nomReal,dni);
        try {
            return carteraClients.addClient(c);

        }catch (Exception e){
            return e.getMessage();
        }
    }



    public boolean addUsuari(String client, String usuari) {

        if((!carteraClients.tooMuchUsers(client)) && (carteraClients.isValidNameUsuari(client,usuari) == "Usuari Unknown")){
            Usuari u = dataService.addUsuari(client,usuari);
            return carteraClients.addUsuariAClient(u);

        }
        return false;
    }
    public boolean tooMuchUsers(String client) {
        return carteraClients.tooMuchUsers(client);
    }
   public String mostrarDetallsSerie(String idSerie){
       return bibliotecaSeries.mostrarDetallsSerie(idSerie);
   }




    public String afegirSerieMyList(String client, String usuari, String idSerie)  {

        dataService.addSerieMylist(client, usuari, idSerie);
        return carteraClients.addSerieMyList(client,usuari,idSerie);

    }

    public String veurePerfil(String clientId, String usuariId) {
        return carteraClients.veurePerfil(clientId,usuariId);
    }


    public String valorarEpisodiAmbThumb(String client, String usuari, String idSerie,
                                         int numTemporada, String idEpisodi, int valoracio) {
        ValoracionsThumb valoracionsThumb = dataService.addValoracioThumb(client,usuari,idSerie,
                numTemporada,idEpisodi,valoracio);
        return carteraClients.addValoracio(valoracionsThumb,client,usuari);
    }
    public String valorarEpisodiAmbEstrella(String client, String usuari, String idSerie,
                                         int numTemporada, String idEpisodi, int valoracio) {
        ValoracionsEstrelles valoracionsEstrelles = dataService.addValoracioEstrella(client,usuari,idSerie,
                numTemporada,idEpisodi,valoracio);
        return carteraClients.addValoracio(valoracionsEstrelles,client,usuari);
    }

    public String veureMyList(String idClient, String idUsuari) {
        return carteraClients.veureMyList(idClient,idUsuari);
    }

    public String startVisualitzacio(String client, String usuari, String serie, int temporada, String episodi) {
        int minuts = bibliotecaSeries.getDuradaEpisodi(serie,temporada,episodi);
        //Visualitz
        Visualitzacio visualitzacio = dataService.addVisualitzacio(client,usuari,serie,temporada,episodi,minuts);
        return carteraClients.startVisualitzacio(client,usuari,visualitzacio);
    }
    public String endVisualitzacio(String client, String usuari, String serie, int temporada,
                                   String episodi,int minutsRestants) {


        return carteraClients.endVisualitzacio(client,usuari,serie,temporada,episodi,minutsRestants);
    }


    public String llistarWatchedList(String client, String usuari) {
        String series = "";
        List<Serie> l = bibliotecaSeries.getAllSeries();
        for(Serie s : l){
            List<Episodi> episodis = bibliotecaSeries.getAllEpisodis(s);
            if(carteraClients.allEpisodisWatched(client,usuari,episodis)){
                series += s.getTitol();
            }
        }
        if(series.isEmpty()){series = "Empty List";}
        return series;
    }
    public String llistarContinueWatching(String client, String usuari) {
        String series = "";
        List<Serie> l = bibliotecaSeries.getAllSeries();
        for(Serie s : l){
            List<Episodi> episodis = bibliotecaSeries.getAllEpisodis(s);
            if(carteraClients.isSerieStarted(client,usuari,episodis) &&
                    !(carteraClients.allEpisodisWatched(client,usuari,episodis))){
                series += s.getTitol();
            }
        }if(series.isEmpty()){series = "Empty List";}
        return series;

    }
    public String llistarCatalegSeries() {
       return bibliotecaSeries.llistarCatalegSeries();
    }


    public String modificarPerfil(String clientName, String username, String newUsername) {
        return carteraClients.modificaPerfil(clientName,username,newUsername);
    }
}
