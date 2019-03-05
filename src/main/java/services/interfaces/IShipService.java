package services.interfaces;

import model.Ship;

import java.util.List;

public interface IShipService {
    List<Ship> getAllShips();
    Ship getShipId(Integer id);
    boolean updateShip(Ship ship);
    boolean createShip(Ship ship);
    boolean deleteShip(Ship ship);
    boolean deleteShipById(Integer id);
}
