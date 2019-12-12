package resources.dao.MOCK;

import ub.edu.resources.dao.DAOClient;
import ub.edu.model.Client;

import java.util.*;

public class DAOClientMOCK implements DAOClient {

    private Map<String, Client> listClients = new HashMap<>();

    public DAOClientMOCK() {
        listClients.put("lmento", new Client("lmento", "lmento",
                "Monumental 2, 00003, Barcelona","Lola Mento","22222222B"));
        listClients.put("ajaleo", new Client("ajaleo", "ajaleo","Madrigal 8, 00001, Barcelona"
                ,"Armando Jaleo","11111111A"));
        listClients.put("dtomacal", new Client("dtomacal", "dtomacal",
                "Sta Eulalia 1, 00031, San Benet del Bages"
                ,"Dolores Tomacal","55555555E"));
    }

    @Override
    public List<Client> getAll() {
        return new ArrayList<>(listClients.values());
    }

    @Override
    public Optional<Client> getById(String id) {
        return Optional.ofNullable(listClients.get(id));
    }

    @Override
    public boolean add(final Client client) {
        if (listClients.containsKey(client.getUsername())) {
            return false;
        }
        listClients.put(client.getUsername(), client);
        return true;
    }

    @Override
    public boolean update(final Client client, String[] params) {
        client.setUsername(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        client.setPassword(Objects.requireNonNull(
                params[1], "Password cannot be null"));
        return listClients.replace(client.getUsername(), client) != null;
    }

    @Override
    public boolean delete(final Client client) {
        return listClients.remove(client.getUsername()) != null;
    }

    @Override
    public Client findClientByUserNAmeAndPassword(String usuari, String pwd) throws Exception {
        if (getById(usuari).isPresent()) {
            Client c = listClients.get(usuari);
            if (c.getPassword().equals(pwd)) {
                return c;
            } else return null;
        } else return null;
    }

}
