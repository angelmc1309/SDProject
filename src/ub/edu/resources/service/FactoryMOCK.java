package resources.service;

import ub.edu.resources.dao.*;
import ub.edu.resources.dao.MOCK.*;

public class FactoryMOCK implements AbstractFactoryData {

    @Override
    public DAOClient createDAOClient() {
        return new DAOClientMOCK();
    }

    @Override
    public DAOSerie createDAOSerie() {
        return new DAOSerieMOCK();
    }

    @Override
    public DAOUsuari createDAOUsuari() { return new DAOUsuariMOCK();
    }

    @Override
    public DAOTemporada createDAOTemporada(){ return new DAOTemporadaMOCK(); }

    @Override
    public DAOValoracions createDAOValoracions() {
        return new DAOValoracionsMOCK();
    }

    @Override
    public DAOEpisodi createDAOEpisodi() {
        return new DAOEpisodiMOCK();
    }

    @Override
    public DAOFavorits createDAOFavorits() {
        return new DAOFavoritsMOCK();
    }

    @Override
    public DAOVisualitzacio createDAOVisualitzacio() {
        return new DAOVisualitzacioMOCK();
    }
}
