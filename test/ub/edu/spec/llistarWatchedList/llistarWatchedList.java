package ub.edu.spec.llistarWatchedList;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class llistarWatchedList {

    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
    }

    public String llistarWatchedList(String client,String usuari){
        return controlador.llistarWatchedList(client,usuari);
    }
}
