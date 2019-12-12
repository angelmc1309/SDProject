package ub.edu.spec.crearusuari;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class crearUsuari {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
    }

    public boolean tooMuchUsers(String client){
        return controlador.tooMuchUsers(client);
    }
    public boolean createUser(String client, String nouUsuari) {
        return controlador.addUsuari(client,nouUsuari);
    }

}
