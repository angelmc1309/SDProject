package resources.service;

import resources.dao.*;

public interface AbstractFactoryData {
    public DAOClient createDAOClient();
    public DAOSerie createDAOSerie();
    public DAOUsuari createDAOUsuari();
    public DAOTemporada createDAOTemporada();
    public DAOEpisodi createDAOEpisodi();
    public DAOValoracions createDAOValoracions();
    public DAOFavorits createDAOFavorits();
    public DAOVisualitzacio createDAOVisualitzacio();




}
