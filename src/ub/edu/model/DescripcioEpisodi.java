package ub.edu.model;

import java.util.Date;

public class DescripcioEpisodi {
    private String idioma, descripcio,enllaç,primeraEmisio;
    private int duracioMinuts;

    public DescripcioEpisodi(String idioma, String descripcio, String enllaç, String primeraEmisio,int durada) {
        this.idioma = idioma;
        this.descripcio = descripcio;
        this.enllaç = enllaç;
        this.primeraEmisio = primeraEmisio;
        this.duracioMinuts = durada;
    }
    public DescripcioEpisodi(int duracioMinuts){
        this.duracioMinuts = duracioMinuts;
    }


    public int getDurada() {
        return duracioMinuts;
    }
}
