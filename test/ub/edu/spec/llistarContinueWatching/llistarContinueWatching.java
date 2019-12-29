package ub.edu.spec.llistarContinueWatching;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class llistarContinueWatching {

    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();
    }

    public String llistarContinueWatching(String client,String usuari){
        return controlador.llistarContinueWatching(client,usuari);
    }
}
