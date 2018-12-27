package services.impl;

import dao.interfaces.IShipDAO;
import model.Ship;
import services.interfaces.IShipService;

public class ShipService implements IShipService {
    private IShipDAO shipDAO;

    public ShipService(IShipDAO shipDAO) {
        this.shipDAO = shipDAO;
    }

    @Override
    public Ship getShipId(Integer id) {
        return shipDAO.getById(id);
    }

    @Override
    public boolean updateShip(Ship ship) {
        return shipDAO.update(ship);
    }

    @Override
    public boolean createShip(Ship ship) {
        return shipDAO.create(ship);
    }

    @Override
    public boolean deleteShip(Ship ship) {
        return shipDAO.delete(ship);
    }

    @Override
    public boolean deleteShipById(Integer id) {
        return shipDAO.deleteById(id);
    }
}
