package model;

public abstract class Valoracions {
    private String usuariId;
    private String episodi;
    public Valoracions(String usuariId, String episodi){
        this.usuariId = usuariId;
        this.episodi = episodi;
    }
    public String getEpisodi(){
        return episodi;
    }
    public String getIdentificador(){
        return usuariId+"@"+episodi;
    }

    /**
     * Mètode per trobar l'id del client
     * @return identificador únic del client
     */
    public String getMyClientId(){
        return getIdentificador().split("@")[0];
    }

    /**
     * Mètode per trobar l'id del usuari
     * @return identificador únic de l'usuari
     */
    public String getMyUserId(){
        return getIdentificador().split("@")[1];
    }

    /**
     *
     * @param  value valor de la valoració
     * @return true si hem pogut fer la valoració
     */
    public abstract boolean setValue(int value);


}
