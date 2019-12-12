package ub.edu.model;

public class Actor {
    private String nomReal, nacionalitat,id;

    public Actor(String id,String nomReal, String nacionalitat) {
        this.id=id;
        this.nomReal = nomReal;
        this.nacionalitat = nacionalitat;
    }

    public String getNomReal(){
        return this.nomReal;
    }

    @Override
    public String toString() {
        return getNomReal()+" ";
    }
}
