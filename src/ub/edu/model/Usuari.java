package model;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuari {
    private Perfil perfil;
    private String clientId;

    private MyList myList;
    //HashMap amb id episodi i visualitzacions
    private HashMap<String,Visualitzacio> visualitzacions;



    public Usuari(String nom, String parent){
        clientId = parent;
        perfil = new Perfil(nom);
        myList = new MyList(getIdentificador());
        visualitzacions = new HashMap<String, Visualitzacio>();

    }

    public String getName() {
        return this.perfil.getName();
    }
    public String setName(String name){
        String toReturn = "User: "+getName();
        this.perfil.setUsername(name);
        toReturn+= " changed to "+getName();
        return toReturn;
    }

    public String getPerfilTextual() {
        return this.perfil.toString();
    }



    public String getClientId() {
        return clientId;
    }



    //test afegir sèries a MyList
    public String addSerieMyList(String idSerie) {

        if (!myList.contains(idSerie)){
            this.myList.addSerie(idSerie);
            return "Sèrie afegida";
        }
        else{
            return "Error: la sèrie ja està a la llista";
        }
    }


    public String getIdentificador(){
        return this.clientId+"@"+this.getName();
    }

    public String setValoracio(Valoracions valoracions) {
        return this.perfil.setValoracio(valoracions);
    }


    public String veureMyList() {
        String list = "Usuari: " + getName();
        if (myList.isEmpty()){
            list = "Llista buida";
        }
        else{
            list += "\nSeries:\n";
            for (String series : myList.getFavorits()){
                list += series + "\n";
            }
        }
        return list;
    }

    public void setMyList(MyList myList) {
        this.myList = myList;
    }


    public String startVisualitzacio(Visualitzacio visualitzacio) {
        visualitzacions.put(visualitzacio.getIdentificador(),visualitzacio);
        return visualitzacio.startVisualitzacio();
    }

    public String endVisualitzacio(String serie, int temporada, String episodi, int minutsRestants) {
        Visualitzacio v = visualitzacions.get(getIdentificador()+"@"+serie+"@"+temporada+"@"+episodi);
        return  v.endVisualitzacio(minutsRestants);


    }

    public boolean allEpisodisWatched(List<Episodi> episodis) {
        boolean allWatched = true;
        for(Episodi episodi:episodis){
            if(visualitzacions.containsKey(this.getIdentificador()+"@"+episodi.getIdentificador())){
                if(!visualitzacions.get(this.getIdentificador()+"@"+episodi.getIdentificador()).isWatched()){
                    allWatched = false;
                }
            }
            else{
                allWatched = false;
            }
        }
        return allWatched;
    }
    public boolean isSerieStarted(List<Episodi> episodis) {
        boolean isStarted = false;
        for(Episodi episodi:episodis){
            if(visualitzacions.containsKey(this.getIdentificador()+"@"+episodi.getIdentificador())){
                if(!visualitzacions.get(this.getIdentificador()+"@"+episodi.getIdentificador()).isNotStarted()){
                    isStarted = true;
                }
            }

        }
        return isStarted;
    }
    public void setVisualitzacio(Visualitzacio visualitzacio) {
        visualitzacions.put(visualitzacio.getIdentificador(),visualitzacio);
    }



}
