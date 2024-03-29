package ub.edu.spec.veurePerfil;


import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;
import model.Usuari;

import java.util.List;

@RunWith(ConcordionRunner.class)
public class veurePerfil {

    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();

    }

    public String veurePerfilUsuari(String clientId,String usuariId){

        return controlador.veurePerfil(clientId,usuariId);
    }


}
/* Usuari --> visualització ---> episodi
                Estat
 */