package dao.interfaces;

import model.Excursion;
import model.dto.ExcursionCruiseDto;

import java.util.List;

public interface IExcursionDAO extends IAbstractDAO<Excursion> {
    List<Excursion> getPortExcursions(int idPort);
    List<Excursion> findCruiseExcursions(int cruiseID);
    List<ExcursionCruiseDto> defineExcursions(int clientID);
}
