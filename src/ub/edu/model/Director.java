package ub.edu.model;

public class Director {
    private String nomReal, nacionalitat,id;

    public Director(String id,String nomReal, String nacionalitat) {
        this.id = id;
        this.nomReal = nomReal;
        this.nacionalitat = nacionalitat;
    }

    @Override
    public String toString() {
        return this.nomReal;
    }
}
