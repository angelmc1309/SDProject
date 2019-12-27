package resources.dao;

import model.Visualitzacio;


public interface DAOVisualitzacio extends DAO<Visualitzacio> {
    public boolean alreadyContainsVisualitzacio(String idVisualitzacio);
}
