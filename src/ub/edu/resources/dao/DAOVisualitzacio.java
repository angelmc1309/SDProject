package ub.edu.resources.dao;

import ub.edu.model.Visualitzacio;


public interface DAOVisualitzacio extends DAO<Visualitzacio> {
    public boolean alreadyContainsVisualitzacio(String idVisualitzacio);
}
