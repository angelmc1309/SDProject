package ub.edu.spec.veurePerfil;


import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.Usuari;

import java.util.List;

@RunWith(ConcordionRunner.class)
public class veurePerfil {

    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();

    }

    public String veurePerfilUsuari(String clientId,String usuariId){

        return controlador.veurePerfil(clientId,usuariId);
    }


}
/* Usuari --> visualització ---> episodi
                Estat
 */