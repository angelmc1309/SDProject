package model;

import java.util.ArrayList;
import java.util.List;


public class Perfil {
    private String username;
    private List<Valoracions> valoracions;




    public Perfil(String nom) {
        this.username = nom;

        this.valoracions= new ArrayList<Valoracions>();

    }

    public String getName() {
        return this.username;
    }
    public void setUsername(String nom) {
        this.username = nom;
    }



    public List<String> mostrarPerfil(){
        List<String> perfil = null;
        perfil.add(getName());

        return perfil;

    }

    @Override
    public String toString() {
        String auxiliar = "Usuari: "+getName();
        if(this.hasValoracions()){
            auxiliar +=" \nValoracions:\n";
            for(Valoracions v:valoracions){
                auxiliar += v.toString()+"\n";
            }
        }else{
            auxiliar +=  " Usuari sense valoracions";
        }

        return auxiliar;

    }

    private boolean hasValoracions() {
        return !valoracions.isEmpty();
    }
    private boolean episodiValoratAnteriorment(Valoracions valoracio){
        boolean toReturn = false;
        for(Valoracions v: valoracions){
            if(v.getEpisodi().equals(valoracio.getEpisodi())){
                toReturn = true;
            }
        }
        return toReturn;
    }
    public String setValoracio(Valoracions valoracions) {
        if(!episodiValoratAnteriorment(valoracions)){
            this.valoracions.add(valoracions);
            return "Episodi valorat correctament";
        }else{
            return "Episodi ja valorat";
        }
    }
}
/*
* package ub.edu.model;

import java.util.ArrayList;
import java.util.List;


public class MyList {
    String idClientUser;
    List<String> favorits;
    public MyList(String idClientUser){
        this.idClientUser = idClientUser;
        favorits = new ArrayList<String>();
    }

    public String getIdentificador() {
        return idClientUser;
    }
    public void addSerie(String serie){
        favorits.add(serie);
    }

    public boolean contains(String idSerie) {
        return favorits.contains(idSerie);
    }

    public boolean isEmpty() {
        return favorits.isEmpty();
    }

    public List<String> getFavorits() {
        return favorits;
    }

    public String getClient() {
        return idClientUser.split("@")[0];
    }

    public String getUser() {
        return idClientUser.split("@")[1];
    }
    //
}

* */