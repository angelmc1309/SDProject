package ub.edu.spec.veureMyList;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class veureMyList {

    private Controller controlador;

    @BeforeExample
    public void init(){
        controlador = new Controller();
    }

    public String veureMyList(String idClient, String idUsuari){
        return controlador.veureMyList(idClient,idUsuari);

    }

}
