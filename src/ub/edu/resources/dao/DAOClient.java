package ub.edu.resources.dao;

import ub.edu.model.Client;
import ub.edu.resources.dao.DAO;

public interface DAOClient extends DAO<Client> {
    public Client  findClientByUserNAmeAndPassword(String usuari, String pwd) throws Exception;

}
