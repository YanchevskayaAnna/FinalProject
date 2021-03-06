package services.interfaces;

import model.Excursion;
import model.dto.ExcursionCruiseDto;

import java.util.List;
import java.util.Map;

public interface IExcursionService {
    List<Excursion> getAllExcursions();
    Excursion getExcursionId(Integer id);
    boolean updateExcursion(Excursion excursion);
    boolean createExcursion(Excursion excursion);
    boolean deleteExcursion(Excursion excursion);
    boolean deleteExcursionById(Integer id);
    List<Excursion> getPortExcursions(int idPort);
    List<Excursion> findCruiseExcursions(int cruiseID);
    List<ExcursionCruiseDto> defineExcursions(int clientID);
}
