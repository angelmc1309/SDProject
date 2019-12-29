package ub.edu.spec.logInClient;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class logInClient {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();
        controlador.iniCarteraClients();
    }

    public boolean isValidLogin(String username, String password) {
        return controlador.validateClient(username, password);
    }

    public String isValidClient(String username) {
        return controlador.isValidNameClient(username);
    }



}
