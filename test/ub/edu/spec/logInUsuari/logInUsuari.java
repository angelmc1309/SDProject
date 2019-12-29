package ub.edu.spec.logInUsuari;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class logInUsuari {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();
    }

    public String isValidUsuari(String client, String usuari) {
        return controlador.isValidNameUsuari(client,usuari);
    }

}
