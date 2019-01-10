package services.impl;

import dao.interfaces.ICruiseRouteDAO;
import model.CruiseRoute;
import model.dto.CruiseRouteDto;
import services.interfaces.ICruiseRouteService;

import java.util.List;

public class CruiseRouteService implements ICruiseRouteService {
    private ICruiseRouteDAO cruiseRouteDAO;

    public CruiseRouteService(ICruiseRouteDAO cruiseRouteDAO) {
        this.cruiseRouteDAO = cruiseRouteDAO;
    }

    @Override
    public List<CruiseRoute> getAllCruises() {
        return cruiseRouteDAO.getAll();
    }

    @Override
    public CruiseRoute getCruiseRouteId(Integer id) {
        return cruiseRouteDAO.getById(id);
    }

    @Override
    public boolean updateCruiseRoute(CruiseRoute cruiseRoute) {
        return cruiseRouteDAO.update(cruiseRoute);
    }

    @Override
    public boolean createCruiseRoute(CruiseRoute cruiseRoute) {
        return cruiseRouteDAO.create(cruiseRoute);
    }

    @Override
    public boolean deleteCruiseRoute(CruiseRoute cruiseRoute) {
        return cruiseRouteDAO.delete(cruiseRoute);
    }

    @Override
    public boolean deleteCruiseRouteById(Integer id) {
        return cruiseRouteDAO.deleteById(id);
    }

    @Override
    public List<CruiseRouteDto> getCruiseRoute(int cruiseID) {
        return cruiseRouteDAO.getCruiseRoute(cruiseID);
    }
}
