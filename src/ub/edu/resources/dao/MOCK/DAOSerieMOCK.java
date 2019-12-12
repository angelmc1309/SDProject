package ub.edu.resources.dao.MOCK;

import ub.edu.model.Actor;
import ub.edu.model.Director;
import ub.edu.model.Productora;
import ub.edu.resources.dao.DAOSerie;
import ub.edu.model.Serie;

import java.util.*;

public class DAOSerieMOCK implements DAOSerie {

    private Map<String, Serie> idToSerie = new HashMap<>();


    public DAOSerieMOCK() {
        // TODO: Posar algunes sèries de la taula hash idToSerie

        Serie serie1=new Serie("bbad", "Breaking Bad");
        serie1.setProductoraData("AMC:Gran_Via_Productions","1","2000");
        serie1.addDirectorData("1","V.Gilligan","EEUU");
        serie1.addActorData("2","B.Cranston","EEUU");
        serie1.addActorData("3","A.Paul","EEUU");
        serie1.addActorData("4","D.Norris","EEUU");
        serie1.setDescripcio("Tras cumplir 50 a\u05EFs, Walter White (Bryan Cranston)" +
                        ", un profesor de quӭica de un instituto de Albuquerque, Nuevo Mϸico, se entera de que tiene un " +
                        "cȮcer de pulmخ incurable. Casado con Skyler (Anna Gunn) y con un hijo discapacitado (RJ Mitte)," +
                        " la brutal noticia lo impulsa a dar un drȳtico cambio a su vida: decide, con la ayuda de un " +
                        "antiguo alumno (Aaron Paul), fabricar anfetaminas y ponerlas a la venta. Lo que pretende es " +
                        "liberar a su familia de problemas econحicos cuando se produzca el fatal desenlace");
        idToSerie.put("bbad", serie1);

        Serie serie2=new Serie("pblinders", "Peaky Blinders");
        serie2.setProductoraData("Caryn_Mandabach_Productions","8","2000");
        serie2.addDirectorData("30","C.Murphy","EEUU");
        serie2.addActorData("31","P.Anderson","EEUU");
        serie2.addActorData("32","J.Cole","EEUU");
        serie2.setDescripcio("A gangster family epic set in 1919 Birmingham, " +
                "England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss " +
                "Tommy Shelby, who means to move up in the world.");
        idToSerie.put("pblinders", serie2);

        Serie serie3=new Serie("mrobot", "Mr Robot");
        serie3.setProductoraData("USA_Network_Universal_Cable_Productions","2","2000");
        serie3.addDirectorData("5","S.Esmail","EEUU");
        serie3.addActorData("6","R.Malek","EEUU");
        serie3.addActorData("7","C.Slater","EEUU");
        serie3.setDescripcio("Elliot Anderson es un joven y brillante programador con " +
                "problemas para las relaciones sociales que durante el dӡ trabaja como tϣnico de ciberseguridad de una " +
                "importante empresa informȴica y por la noche es un desinteresado justiciero cibernϴico, que se " +
                "verǠenvuelto en una oscura trama.");
        idToSerie.put("mrobot", serie3);
    }


    @Override
    public List<Serie> getAll() {
        return new ArrayList<>(idToSerie.values());
    }

    @Override
    public Optional<Serie> getById(String id) {
        return Optional.ofNullable(idToSerie.get(id));
    }

    @Override
    public boolean add(final Serie serie) {

        if (getById(serie.getTitol()).isPresent()) {
            return false;
        }
        idToSerie.put(serie.getTitol(), serie);
        return true;
    }

    @Override
    public boolean update(final Serie serie, String[] params) {
        serie.setTitol(Objects.requireNonNull(
                params[0], "Title cannot be null"));

        return idToSerie.replace(serie.getTitol(), serie) != null;
    }

    @Override
    public boolean delete(final Serie serie) {
        return idToSerie.remove(serie.getTitol()) != null;
    }

}
