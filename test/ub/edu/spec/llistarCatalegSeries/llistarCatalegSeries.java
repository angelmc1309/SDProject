package ub.edu.spec.llistarCatalegSeries;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

@RunWith(ConcordionRunner.class)
public class llistarCatalegSeries {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();
    }
    //nomes cataleg series disponibles
    public String llistarCatalegSeries(){
        return controlador.llistarCatalegSeries();
    }


}
