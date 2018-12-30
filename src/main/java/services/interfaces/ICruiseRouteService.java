package services.interfaces;

import model.CruiseRoute;
import java.util.List;

public interface ICruiseRouteService {
    List<CruiseRoute> getAllCruises();
    CruiseRoute getCruiseRouteId(Integer id);
    boolean updateCruiseRoute(CruiseRoute cruiseRoute);
    boolean createCruiseRoute(CruiseRoute cruiseRoute);
    boolean deleteCruiseRoute(CruiseRoute cruiseRoute);
    boolean deleteCruiseRouteById(Integer id);
    List<CruiseRoute> getCruiseRoute(int cruiseID);
}
