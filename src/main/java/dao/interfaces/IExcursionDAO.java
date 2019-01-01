package dao.interfaces;

import model.Bonus;
import model.Excursion;

import java.util.List;

public interface IExcursionDAO extends IAbstractDAO<Excursion> {
    List<Excursion> getPortExcursions(int idPort);
    List<Excursion> findCruiseExcursions(int cruiseID);
}
