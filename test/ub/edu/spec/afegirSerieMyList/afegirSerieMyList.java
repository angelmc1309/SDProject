package ub.edu.spec.afegirSerieMyList;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class afegirSerieMyList {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();
    }


    public String afegirSerieMyList(String client, String usuari, String idSerie) {
        return controlador.afegirSerieMyList(client, usuari ,idSerie);
    }


}
