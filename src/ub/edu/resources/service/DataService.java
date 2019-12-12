package ub.edu.resources.service;

import ub.edu.model.*;
import ub.edu.resources.dao.*;
import ub.edu.resources.service.AbstractFactoryData;

import java.util.List;
import java.util.Optional;


public class DataService {
    private DAOSerie serieDAO;
    private DAOClient clientDAO;
    private DAOUsuari usuariDAO;
    private DAOTemporada temporadaDAO;
    private DAOEpisodi episodiDAO;
    private DAOValoracions valoracionsDAO;
    private DAOFavorits favoritsDAO;
    private DAOVisualitzacio visualitzacioDAO;


    public DataService(AbstractFactoryData factory)  {
        this.serieDAO = factory.createDAOSerie();
        this.clientDAO = factory.createDAOClient();
        this.usuariDAO = factory.createDAOUsuari();
        this.temporadaDAO = factory.createDAOTemporada();
        this.episodiDAO = factory.createDAOEpisodi();
        this.valoracionsDAO = factory.createDAOValoracions();
        this.favoritsDAO = factory.createDAOFavorits();
        this.visualitzacioDAO = factory.createDAOVisualitzacio();
    }

    public Client getClientByUsuariAndPassword(String usuari, String password) {
        try {
            return clientDAO.findClientByUserNAmeAndPassword(usuari, password);
        } catch (Exception e) {
            //TODO
        }
        return null;
    }

    public List<Client> getAllClients() {
        try {
            return clientDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public Client addClient(String username, String password, String adreça, String nomReal,String dni) {
        Client c = new Client(username,password,adreça,nomReal,dni);
        try{
            clientDAO.add(c);
            return c;
        }catch (Exception e){
            return null;
        }

    }
    public ValoracionsThumb addValoracioThumb(String client,String usuari,String serie,
                                              int temporada,String episodi,int value){
        ValoracionsThumb valoracionsThumb= new ValoracionsThumb(client+"@"+usuari,serie+"@"+
                temporada+"@"+episodi);
        valoracionsThumb.setValue(value);
        try{
            valoracionsDAO.add(valoracionsThumb);
            return valoracionsThumb;
        }catch (Exception e){
            return null;
        }
    }
    public ValoracionsEstrelles addValoracioEstrella(String client,String usuari,String serie,
                                              int temporada,String episodi,int value){
        ValoracionsEstrelles valoracionsEstrella= new ValoracionsEstrelles(client+"@"+usuari,serie+"@"+
                temporada+"@"+episodi);
        valoracionsEstrella.setValue(value);
        try{
            valoracionsDAO.add(valoracionsEstrella);
            return valoracionsEstrella;
        }catch (Exception e){
            return null;
        }
    }

    public Visualitzacio addVisualitzacio(String client, String usuari, String serie, int temporada, String episodi, int minuts) {
        Visualitzacio visualitzacio = new Visualitzacio(client, usuari, serie + "@" + temporada + "@" + episodi, minuts);


        try {
            if(visualitzacioDAO.alreadyContainsVisualitzacio(visualitzacio.getIdentificador())){
                return  visualitzacioDAO.getById(visualitzacio.getIdentificador()).get();
            }
            visualitzacioDAO.add(visualitzacio);
            return visualitzacio;
        } catch (Exception e) {
            return null;
        }
    }
    public Usuari addUsuari(String idClient,String usuari){
        Usuari u = new Usuari(usuari,idClient);
        try{
            usuariDAO.add(u);
            return u;
        }catch(Exception e){
            return null;
        }
    }
    public void addSerieMylist(String client ,String usuari,String serie){
        try{
            MyList m = favoritsDAO.getById(client+"@"+usuari+"@"+serie).get();
            m.addSerie(serie);

        }catch(Exception e){

        }
    }

    public List<Usuari> getAllUsuaris(){
        try {
            return usuariDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }



    public List<Serie> getAllSeries(){
        try{
            return serieDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Temporada> getAllTemporades(){
        try{
            return temporadaDAO.getAll();
        } catch (Exception e) {
            return null;
        }

    }
    public List<Episodi> getAllEpisodis(){
        try{
            return episodiDAO.getAll();
        } catch (Exception e) {
            return null;
        }

    }
    public List<Valoracions> getAllValoracions(){
        try{
            return valoracionsDAO.getAll();

        }catch (Exception e){
            return null;
        }
    }

    public List<MyList> getAllFavorits() {
        try{
            return favoritsDAO.getAll();

        }catch (Exception e){
            return null;
        }
    }
    public List<Visualitzacio> getAllVisualitzacions(){
        try{
            return visualitzacioDAO.getAll();

        }catch (Exception e){
            return null;
        }
    }








}
