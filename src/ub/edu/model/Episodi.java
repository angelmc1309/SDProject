package model;



public class Episodi {
    private String nom;
    private String idTemporada;
    private DescripcioEpisodi descripcioEpisodi;



    public Episodi(String idTemporada,String nom,int durada){
        this.nom = nom;
        this.idTemporada = idTemporada;
        descripcioEpisodi = new DescripcioEpisodi(durada);
    }


    public String getNom() {
        return nom;
    }

    public String getIdentificador(){
        return idTemporada+"@"+nom;
    }
    public String getIdTemporada(){return idTemporada.split("@")[1];}
    public String getIdSerie(){return idTemporada.split("@")[0];}

    public int getDuradaEpisodi(){
        return descripcioEpisodi.getDurada();
    }





    @Override
    public String toString() {
        return "Episodi:"+getNom()+"de la Serie: "+idTemporada;
    }
}
