package resources.dao;

import ub.edu.model.Client;

public interface DAOClient extends DAO<Client> {
    public Client  findClientByUserNAmeAndPassword(String usuari, String pwd) throws Exception;

}
