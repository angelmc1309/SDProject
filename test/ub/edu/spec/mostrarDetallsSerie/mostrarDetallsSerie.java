package ub.edu.spec.mostrarDetallsSerie;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;

import java.util.List;

@RunWith(ConcordionRunner.class)
public class mostrarDetallsSerie {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
    }

    public String mostrarDetallsSerie(String idSerie){
        return controlador.mostrarDetallsSerie(idSerie);
    }
}
