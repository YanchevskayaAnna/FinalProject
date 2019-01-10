package dao.interfaces;

import model.CruiseRoute;
import model.dto.CruiseRouteDto;

import java.util.List;

public interface ICruiseRouteDAO extends IAbstractDAO<CruiseRoute> {
    List<CruiseRouteDto> getCruiseRoute(int cruiseID);
}
