package services.interfaces;

import model.Excursion;

public interface IExcursionService {
    Excursion getExcursionId(Integer id);
    boolean updateExcursion(Excursion excursion);
    boolean createExcursion(Excursion excursion);
    boolean deleteExcursion(Excursion excursion);
    boolean deleteExcursionById(Integer id);
}
