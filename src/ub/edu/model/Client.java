package ub.edu.model;



import java.util.HashMap;
import java.util.List;


public class Client {
    private final static int MAX_USERS = 5;
    private HashMap<String, Usuari> usuaris;
    private String dni,username,adreça,nomReal,password;

    public Client( String username,String password,String adreça,String nomReal,String dni) {

        this.usuaris = new HashMap<String,Usuari>();
        this.username = username;
        this.password = password;
        this.adreça = adreça;
        this.nomReal = nomReal;
        this.dni = dni;

    }



    public Usuari findUser(String name) {

        return usuaris.get(name);

    }


    public boolean addUsuariToClient(Usuari user){
        if(tooMuchUsers())
            return false;
        this.usuaris.put(user.getName(),user);
        return true;

    }


    public String getPerfilTextualUsuari(String usuari) {
        return this.findUser(usuari).getPerfilTextual();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean tooMuchUsers() {
        return this.usuaris.size() >= MAX_USERS;
    }

    public String veurePerfil(String usuariId) {
        return findUser(usuariId).getPerfilTextual();
    }



    public String veureMyList(String idUsuari) {
        return findUser(idUsuari).veureMyList();
    }

    public String startVisualitzacio(String usuari, Visualitzacio visualitzacio) {
        return findUser(usuari).startVisualitzacio(visualitzacio);
    }

    public String endVisualitzacioUser(String usuari, String serie, int temporada, String episodi, int minutsRestants) {
        return findUser(usuari).endVisualitzacio(serie,temporada,episodi,minutsRestants);
    }

    public String addSerieMyListToUser(String usuari, String idSerie) {
        return findUser(usuari).addSerieMyList(idSerie);
    }

    public String setValoracioToUser(String usuari, Valoracions valoracions) {
        return findUser(usuari).setValoracio(valoracions);
    }

    public void setMyListToUser(String user, MyList myList) {
        findUser(user).setMyList(myList);
    }

    public boolean allEpisodisWatched(String usuari, List<Episodi> episodis) {
        return findUser(usuari).allEpisodisWatched(episodis);
    }

    public void setVisualitzacioToUser(String user, Visualitzacio visualitzacio) {
        findUser(user).setVisualitzacio(visualitzacio);
    }

    public boolean isSerieStarted(String usuari, List<Episodi> episodis) {
        return findUser(usuari).isSerieStarted(episodis);
    }

    public String modificaPerfil(String username, String newUsername) {
        if(findUser(username) == null){
            return "Usuari Unknown";
        }
        return findUser(username).setName(newUsername);
    }
}
