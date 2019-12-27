package model;

public class Visualitzacio {

    private String clientId,usuariId,episodiId;
    private EstatVisualitzacio estat;
    private int minutsRestants,minutsEpisodi;
    public Visualitzacio(String clientId,String usuariId,String episodiId,int minutsEpisodi){
        this.clientId = clientId;
        this.episodiId =episodiId;
        this.usuariId = usuariId;
        estat = new EstatVisualitzacio(EstatVisualitzacio.NOT_STARTED);
        this.minutsEpisodi = minutsEpisodi;
        this.minutsRestants = minutsEpisodi;
    }
    public String startVisualitzacio(){
        estat.setState(EstatVisualitzacio.STARTED);
        if(minutsEpisodi == minutsRestants){
            return "Episodi començat pel principi";
        }else{
            return "Episodi començat pel minut:"+(minutsEpisodi-minutsRestants);
        }
    }
    public String endVisualitzacio(int minutsRestants){
        this.minutsRestants = minutsRestants;
        if(minutsRestants == 0) {
            estat.setState(EstatVisualitzacio.ENDED);
            return "Episodi acabat";
        }else{
            estat.setState(EstatVisualitzacio.STARTED);
            return "Episodi deixat a mitges";
        }
    }

    public String getIdentificador() {
        return clientId+"@"+usuariId+"@"+episodiId;
    }

    public boolean isWatched() {
        return estat.getState() == EstatVisualitzacio.ENDED;
    }
    public boolean isNotStarted(){
        return estat.getState() == EstatVisualitzacio.NOT_STARTED;
    }

    public String getClient() {
        return clientId;
    }

    public String getUser() {
        return usuariId;
    }
}
