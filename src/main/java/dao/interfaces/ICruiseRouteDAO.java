package dao.interfaces;

import model.CruiseRoute;

import java.util.List;

public interface ICruiseRouteDAO extends IAbstractDAO<CruiseRoute> {
    List<CruiseRoute> getCruiseRoute(int cruiseID);
}
