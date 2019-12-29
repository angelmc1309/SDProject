package ub.edu.spec.visualitzarEpisodi;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class visualitzarEpisodi {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();

    }
    public String startVisualitzacio(String client,String usuari,String serie,int temporada,String episodi){
        return controlador.startVisualitzacio(client,usuari,serie,temporada,episodi);
    }
    public String endVisualitzacio(String client,String usuari,String serie,int temporada,
                                   String episodi,int minutsRestants){
        return controlador.endVisualitzacio(client,usuari,serie,temporada,episodi,minutsRestants);
    }
}
