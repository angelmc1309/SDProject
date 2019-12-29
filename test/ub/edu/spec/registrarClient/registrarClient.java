package ub.edu.spec.registrarClient;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import controller.Controller;
import resources.dao.MOCK.DAOClientMOCK;

@RunWith(ConcordionRunner.class)
public class registrarClient {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = Controller.getInstance();

    }


    /**@author : Angel*/
    public String altaClient(String username,String password,String adreça,String nomReal,String dni){
        return controlador.addClient(username,password,adreça,nomReal,dni);

    }

}