package services.interfaces;

import model.Excursion;

import java.util.List;

public interface IExcursionService {
    List<Excursion> getAllExcursions();
    Excursion getExcursionId(Integer id);
    boolean updateExcursion(Excursion excursion);
    boolean createExcursion(Excursion excursion);
    boolean deleteExcursion(Excursion excursion);
    boolean deleteExcursionById(Integer id);
}
