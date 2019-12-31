package controller;

import model.*;
import resources.service.AbstractFactoryData;
import resources.service.DataService;
import resources.service.FactoryMOCK;
import view.Observer;
import view.UBFLIX;

import java.util.*;

public class Controller {

    private AbstractFactoryData factory;      // Origen de les dades
    private DataService dataService;         // Connexio amb les dades
    private CarteraClients carteraClients;  //Model
    private BibliotecaSeries bibliotecaSeries;

    private volatile static Controller uniqueInstance;


    public static Controller getInstance() {
        if (uniqueInstance == null) {
            synchronized (Controller.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Controller();
                }
            }
        }
        return uniqueInstance;
    }
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
    public void logClient(String clientName){
        LoggedClient.getInstance().setClient(clientName);
    }
    public void logUser(String username) {
        LoggedUser.getInstance().setUser(username);
    }
    public String getLoggedUser(){
        return LoggedUser.getInstance().getUser();
    }
    public String getLoggedClient(){
        return LoggedClient.getInstance().getClient();
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
        String [] s = carteraClients.veureMyList(idClient,idUsuari).split("\n");

        String returnVal = "";
        for(String a :s ){
            if(a.equals("")){break;}
            returnVal += bibliotecaSeries.find(a).getTitol()+"\n";

        }
        return returnVal;
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
                series += s.getTitol()+"\n";
            }
        }
        return series;
    }
    public String llistarContinueWatching(String client, String usuari) {
        String series = "";
        List<Serie> l = bibliotecaSeries.getAllSeries();
        for(Serie s : l) {
            List<Episodi> episodis = bibliotecaSeries.getAllEpisodis(s);
            if (carteraClients.isSerieStarted(client, usuari, episodis) &&
                    !(carteraClients.allEpisodisWatched(client, usuari, episodis))) {
                series += s.getTitol() + "\n";
            }
        }
        return series;

    }
    public String llistarCatalegSeries() {
       return bibliotecaSeries.llistarCatalegSeries();
    }


    public String modificarPerfil(String clientName, String username, String newUsername) {
        return carteraClients.modificaPerfil(clientName,username,newUsername);
    }

    public String[] getTemporadaSerie(String serie) {
        return bibliotecaSeries.getTemporadaSerie(serie);
    }

    public String[] getEpisodisTemporada(String serie, String temporada) {
        return bibliotecaSeries.getEpisodiTemporada(serie,temporada);
    }


    public String getIdSerie(String serie) {
        return bibliotecaSeries.getIdSerie(serie);
    }

    public int getDuracioEpisodi(String idSerie, String temporada, String episodi) {
        return bibliotecaSeries.getDuradaEpisodi(idSerie,Integer.parseInt(temporada),episodi);
    }

    public void attachObserverLoggedUser(Observer o) {
        LoggedUser.getInstance().attach(o);

    }

    public void attachObserverLoggedClient(Observer o) {
        LoggedClient.getInstance().attach(o);
    }


    public String getUser(String username) {
        return carteraClients.find(username).getFirstUser();
    }

    public ArrayList<String> getAllUsers(String actualClient) {
        return carteraClients.getAllUSers(actualClient);
    }

    public String[] topVisualitzacions(){
        /*
        List<Visualitzacio> visualitzacions= dataService.getAllVisualitzacions();
        List<Serie> series = dataService.getAllSeries();
        int size ;
        if(series.size() < 10){size = series.size();}
        else{size = 10;}
        Integer[] punts = new Integer[series.size()];
        String[] returnVal = new String[size];
        for(Visualitzacio v : visualitzacions){
            if(v.isWatched()){
                String idSerie = v.getSerie();
                for(Serie s : series){
                    if(s.getIdSerie().equals(idSerie)){
                        punts[series.indexOf(s)] =new Integer(1+punts[series.indexOf(s)].intValue()) ;

                    }
                }
            }
        }
        for(int j = 0;j<size;j++) {
            int max = 0;
            for (int i = 0; i < punts.length; i++) {
                if (punts[i] > max) {
                    max = punts[i];
                }
            }
            int index = java.util.Arrays.asList(punts).indexOf(new Integer(max));
            returnVal[j] = series.get(index).getTitol();
        }
        return returnVal;*/
        return new String[0];

    }
    public String[] topValoracions(){
        /*
        List<Valoracions> valoracions= dataService.getAllValoracions();
        List<Serie> series = dataService.getAllSeries();
        int size ;
        if(series.size() < 10){size = series.size();}
        else{size = 10;}
        Integer[] punts = new Integer[series.size()];
        String[] returnVal = new String[size];
        for(Valoracions v : valoracions){

            String idSerie = v.getSerie();
            for(Serie s : series){
                if(s.getIdSerie().equals(idSerie)){
                    punts[series.indexOf(s)] =new Integer(v.getValue()+punts[series.indexOf(s)].intValue()) ;
                }
            }
        }
        for(int j = 0;j<size;j++) {
            int max = 0;
            for (int i = 0; i < punts.length; i++) {
                if (punts[i] > max) {
                    max = punts[i];
                }
            }
            int index = java.util.Arrays.asList(punts).indexOf(new Integer(max));
            returnVal[j] = series.get(index).getTitol();
        }
        return returnVal;*/

        return new String[0];
    }


}
