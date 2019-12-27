package ub.edu.spec.modificarPerfil;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class modificarPerfil {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
    }

    public String modificarPerfil(String clientName, String username, String newUsername){ return controlador.modificarPerfil(clientName, username, newUsername); }

}
