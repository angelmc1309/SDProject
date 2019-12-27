package model;

public class Productora {
    private String nom, id,anyCreacio;


    public Productora(String nom, String id,String anyCreacio) {
        this.nom = nom;
        this.id = id;
        this.anyCreacio = anyCreacio;
    }

    public String getNom(){ return this.nom; }

    public String getId(){ return this.id; }

    public String getAnyCreacio(){ return this.anyCreacio; }

    @Override
    public String toString(){
        String auxiliar = getId() +"\n";
        auxiliar += nom + "\n";
        return auxiliar;
    }

}


