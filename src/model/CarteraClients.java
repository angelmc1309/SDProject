package model;

import java.util.ArrayList;
import java.util.List;

public class CarteraClients {
    private List<Client> llista;

    public CarteraClients(List<Client> allClients) {
        llista = allClients;
    }

    public Client find(String username) {

        for (Client c: llista) {
            if (c.getUsername().equals(username)) return c;
        }
        return null;

    }



    public String getClientPassword(String username)throws Exception{
        Client myClient = find(username);
        if(myClient == null){
            throw new Exception();
        }
        return myClient.getPassword();
    }

    public String addClient(Client client) throws Exception{
        if(find(client.getUsername()) != null){
            throw new Exception("Usuari ja existeix");
        }

        llista.add(client);
        return "Client afegit";
    }
    public String getPerfilUsuariClient(String client,String usuari){
        return find(client).getPerfilTextualUsuari(usuari);
    }

    public boolean addUsuariAClient(Usuari user){
        return find(user.getClientId()).addUsuariToClient(user);
    }

    public void updateUsers(List<Usuari> l) {
        for (Usuari usuari : l){
            find(usuari.getClientId()).addUsuariToClient(usuari);

        }
    }

    public boolean tooMuchUsers(String client) {
        return find(client).tooMuchUsers();
    }

    public String veurePerfil(String clientId, String usuariId) {
        return find(clientId).veurePerfil(usuariId);
    }
    public void updateValoracions(List<Valoracions> l) {
        for(Valoracions valoracions:l){
            find(valoracions.getMyClientId()).setValoracioToUser(valoracions.getMyUserId(),valoracions);
        }
    }
    public void updateFavorits(List<MyList> l) {
        for(MyList myList:l){
            find(myList.getClient()).setMyListToUser(myList.getUser(),myList);
        }
    }
    public void updateVisualitzacions(List<Visualitzacio> l) {
        for(Visualitzacio visualitzacio:l){
            find(visualitzacio.getClient()).setVisualitzacioToUser(visualitzacio.getUser(),visualitzacio);
        }
    }

    public String addValoracio(Valoracions valoracions, String client, String usuari) {
        return find(client).setValoracioToUser(usuari,valoracions);
    }


    public String addSerieMyList(String client, String usuari, String idSerie)  {
        return find(client).addSerieMyListToUser(usuari,idSerie);
    }

    public String veureMyList(String idClient, String idUsuari) {
        return find(idClient).veureMyList(idUsuari);
    }



    public String isValidNameUsuari(String client, String user) {
        Usuari usuari = find(client).findUser(user);
        if (usuari != null) return "Valid Usuari";
        else return "Usuari Unknown";
    }

    public String startVisualitzacio(String client, String usuari, Visualitzacio visualitzacio) {
        return find(client).startVisualitzacio(usuari,visualitzacio);
    }

    public String endVisualitzacio(String client, String usuari, String serie, int temporada, String episodi, int minutsRestants) {
        return find(client).endVisualitzacioUser(usuari,serie,temporada,episodi,minutsRestants);
    }

    public boolean allEpisodisWatched(String client, String usuari, List<Episodi> episodis) {
        return find(client).allEpisodisWatched(usuari,episodis);
    }


    public boolean isSerieStarted(String client, String usuari, List<Episodi> episodis) {
        return find(client).isSerieStarted(usuari,episodis);
    }

    public String modificaPerfil(String clientName, String username, String newUsername) {
        return find(clientName).modificaPerfil(username,newUsername);

    }

    public ArrayList<String> getAllUSers(String actualClient) {
        return find(actualClient).getAllUsers();
    }
}
