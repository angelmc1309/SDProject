package resources.dao;

import model.Client;
import resources.dao.DAO;

public interface DAOClient extends DAO<Client> {
    public Client  findClientByUserNAmeAndPassword(String usuari, String pwd) throws Exception;

}
